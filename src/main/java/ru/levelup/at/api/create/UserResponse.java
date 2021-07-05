package ru.levelup.at.api.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class UserResponse {

    private String id;
    private String name;
    private String job;
    private String createdAt;
}
