package org.example.todoweb.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.todoweb.entity.UserEntity;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime ModifiedAt;

    public UserResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.name = userEntity.getName();
        this.email = userEntity.getEmail();
        this.createdAt = userEntity.getCreatedAt();
        this.ModifiedAt = userEntity.getModifiedAt();
    }
}
