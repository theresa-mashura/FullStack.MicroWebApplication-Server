package com.GroupProject.VideoApp.services;

import com.GroupProject.VideoApp.models.Video;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
@Slf4j  // Lombok - allows us to use log without having to create logger factory
public class VideoStorageService {

    @Value("${application.bucket.name}")
    private String bucketName;

    @Autowired
    private AmazonS3 s3Client;

    @Autowired
    private VideoDataService videoDataService;

    // Add Video to VideoDataRepository & upload the file
    public Long uploadFile(MultipartFile file, String title, String description, String category) {
        Video newVideo = new Video();
        newVideo.setVideoPostedDate(new Date());
        newVideo.setTitle(title);
        newVideo.setDescription(description);
        newVideo.setCategory(category);
        //newVideo.setUserId(userId);
        Long videoId = videoDataService.add(newVideo).getVideoId();

        File fileObj = convertMultiPartFileToFile(file);
        String filename = videoId.toString(); /*+ "_" + file.getOriginalFilename();*/
        s3Client.putObject(
                new PutObjectRequest(bucketName, filename, fileObj)
        );
        fileObj.delete(); // delete so it doesn't keep adding it
        return videoId;
    }

    // Use %20 for spaces in filenames when testing via Insomnia, Postman, etc.
    // Delete from AWS S3 and from VideoDataRepository
    public String deleteFile(String filename) {
        Long videoId = Long.parseLong(filename.substring(0, filename.indexOf("_")));
        s3Client.deleteObject(bucketName, filename);
        videoDataService.remove(videoId);
        return filename + " removed." + videoId;
    }

    public byte[] downloadFile(String filename) {
        S3Object s3Object = s3Client.getObject(bucketName, filename);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public File convertMultiPartFileToFile(MultipartFile file) {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        } catch (IOException e) {
            log.error("Error converting multipartFile to file", e);
        }

        return convertedFile;
    }

}
