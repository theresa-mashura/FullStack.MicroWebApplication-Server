package com.GroupProject.VideoApp;


import com.GroupProject.VideoApp.models.User;
import com.GroupProject.VideoApp.models.Video;
import com.GroupProject.VideoApp.repositories.VideoDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class VideoDataControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VideoDataRepository videoRepo;


    @Test
    public void getVideoByIdTest() throws Exception {
        Long givenId = 1L;
        BDDMockito
                .given(videoRepo.findById(givenId))
                .willReturn(Optional.of(new Video()));

        String expectedContent = "{\"videoId\":null,\"title\":null,\"userId\":null,\"lengthOfVideo\":null," +
                "\"viewCount\":0,\"description\":null,\"videoPostedDate\":null,\"likeCount\":0,\"dislikeCount\":0,\"category\":null,\"comments\":null}";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/video/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }


}
