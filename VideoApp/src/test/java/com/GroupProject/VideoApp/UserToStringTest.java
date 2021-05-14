package com.GroupProject.VideoApp;

import com.GroupProject.VideoApp.models.User;
import org.junit.Test;

public class UserToStringTest {
    @Test
    public void test() {
    // given
        User user = new User();
    // when
        String actual = user.toString();
    // then
        System.out.println(actual);
    }
}
