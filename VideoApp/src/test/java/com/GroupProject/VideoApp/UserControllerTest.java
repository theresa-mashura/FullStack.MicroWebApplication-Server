package com.GroupProject.VideoApp;


import com.GroupProject.VideoApp.models.User;
import com.GroupProject.VideoApp.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository repository;

    @Test
    public void testGetUser() throws Exception {
        Long givenId = 1L;
        BDDMockito
                .given(repository.findById(givenId))
                .willReturn(Optional.of(new User()));

        String expectedContent = "{\"userId\":null,\"email\":null,\"userName\":null,\"password\":null,\"firstName\":null,\"lastName\":null,\"role\":null}";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/user/" + givenId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

//    @Test
//    public void testCreateUser() throws Exception {
//        User users = new User();
//        BDDMockito
//                .given(repository.save(users))
//                .willReturn(users);
//
//        String expectedReturn = "{\"userId\":null,\"email\":null,\"userName\":null,\"password\":null,\"firstName\":null,\"lastName\":null,\"role\":null}";
//        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/")
//        .content(expectedReturn)
//        .accept(MediaType.APPLICATION_JSON)
//        .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.content().string(expectedReturn));
//
//    }











}
