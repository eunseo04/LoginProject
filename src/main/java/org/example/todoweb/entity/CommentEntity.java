package org.example.todoweb.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentEntity extends BaseEntity {
    //댓글 내용, 작성일, 수정일, 유저 고유 식별자, 일정 고유 식별자
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "todo_entity_id")
    private TodoEntity todoEntity;

    public CommentEntity(String comment, TodoEntity todoEntity) {
        this.userId = todoEntity.getUserEntity().getId();
        this.comment = comment;
        this.todoEntity = todoEntity;
    }

    public void update(String comment) {
        this.comment = comment;
    }
}
