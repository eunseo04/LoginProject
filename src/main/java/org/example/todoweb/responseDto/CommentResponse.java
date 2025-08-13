package org.example.todoweb.responseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.todoweb.entity.CommentEntity;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResponse {
    private Long id;
    private Long userId;
    private Long todoId;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public CommentResponse(CommentEntity commentEntity) {
        this.id = commentEntity.getId();
        this.userId = commentEntity.getUserEntity().getId();
        this.todoId = commentEntity.getTodoEntity().getId();
        this.comment = commentEntity.getComment();
        this.createdAt = commentEntity.getCreatedAt();
        this.modifiedAt = commentEntity.getModifiedAt();
    }
}
