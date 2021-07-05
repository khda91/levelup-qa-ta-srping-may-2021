package ru.levelup.at.api.get;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGetResponse {

    private UserGetData data;
}
