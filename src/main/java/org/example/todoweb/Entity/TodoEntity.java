package org.example.todoweb.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.todoweb.RequestDto.TodoRequest;


import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="todo")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class TodoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_entity_id")
    private UserEntity userEntity;
    private String title;
    private String description;

    public TodoEntity(UserEntity userEntity, String title, String description) {
        this.userEntity = userEntity;
        this.title = title;
        this.description = description;
    }

    public void modify(TodoRequest todoRequest) {
        this.title = todoRequest.getTitle();
        this.description = todoRequest.getDescription();
    }
}
