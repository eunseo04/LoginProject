package org.example.todoweb.RequestDto;

import lombok.Getter;

@Getter
public class UserRequest {
    //@NotNull
    private String name;
    private String email;
    private String password;
}
