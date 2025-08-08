package org.example.todoweb.ResponseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.todoweb.Entity.TodoEntity;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TodoResponse {
    private Long id;
    private Long userId;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public TodoResponse(TodoEntity entity) {
        this.id = entity.getId();
        this.userId = entity.getUserEntity().getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.createdAt = entity.getCreatedAt();
        this.modifiedAt = entity.getModifiedAt();
    }
}
