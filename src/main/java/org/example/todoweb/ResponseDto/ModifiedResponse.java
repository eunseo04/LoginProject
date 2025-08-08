package org.example.todoweb.ResponseDto;

import lombok.Getter;
import org.example.todoweb.Entity.TodoEntity;

@Getter
public class ModifiedResponse {
    private String title;
    private String description;

    public ModifiedResponse(TodoEntity todoEntity) {
        this.title = todoEntity.getTitle();
        this.description = todoEntity.getDescription();
    }
}
