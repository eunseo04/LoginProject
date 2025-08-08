package org.example.todoweb.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.todoweb.RequestDto.TodoRequest;


import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="members")
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class TodoEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public TodoEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void modify(TodoRequest todoRequest) {
        this.title = todoRequest.getTitle();
        this.description = todoRequest.getDescription();
    }
}
