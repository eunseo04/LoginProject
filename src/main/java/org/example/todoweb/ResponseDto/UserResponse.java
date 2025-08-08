package org.example.todoweb.ResponseDto;

import lombok.Getter;
import org.example.todoweb.Entity.UserEntity;

@Getter
public class UserResponse {
    private Long id;
    private String name;
    private String email;

    public UserResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
    }
}
