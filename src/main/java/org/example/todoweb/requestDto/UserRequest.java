package org.example.todoweb.requestDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRequest {
    @NotEmpty
    @Size(min = 1, max = 10) //유저명은 10글자 이내
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
