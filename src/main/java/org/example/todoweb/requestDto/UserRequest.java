package org.example.todoweb.requestDto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class UserRequest {
    @NotEmpty
    @Range(min = 1, max = 4) //유저명은 4글자 이내
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
}
