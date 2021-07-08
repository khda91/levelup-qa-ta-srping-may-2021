package ru.levelup.at.design.patterns.builder;

import org.testng.annotations.Test;

public class UserBuilderTest {

    @Test
    public void userBuilderTest() {
        User user1 = User.builder()
                         .email("hhggsd!@hsdvs.com")
                         .address("jjjuuuuwewe")
                         .age(22)
                         .build();
        System.out.println(user1);
    }

    @Test
    public void userBuilderLombokTest() {
        UserLombok user1 = UserLombok.builder()
                         .email("hhggsd!@hsdvs.com")
                         .address("jjjuuuuwewe")
                         .age(22)
                         .build();
        System.out.println(user1);
    }
}
