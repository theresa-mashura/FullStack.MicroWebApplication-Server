package com.GroupProject.VideoApp.controllers;


import com.GroupProject.VideoApp.services.VideoStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@RequestMapping("/file")
@CrossOrigin
public class VideoStorageController {

    private VideoStorageService service;

    @Autowired
    public VideoStorageController(VideoStorageService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<Long> uploadFile(@RequestParam(value = "file") MultipartFile file, @RequestParam(value="title") String title,
                                           @RequestParam(value="description") String description, @RequestParam(value="category") String category
                                           ) {
        return new ResponseEntity<>(service.uploadFile(file, title, description, category), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{filename}")
    public ResponseEntity<String> deleteFile (@PathVariable String filename) {
        return new ResponseEntity<>(service.deleteFile(filename), HttpStatus.OK);
    }

    @GetMapping("/download/{filename}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String filename) {
        byte[] data = service.downloadFile(filename);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment;filename=\"" + filename + "\"")
                .body(resource);
    }
}
