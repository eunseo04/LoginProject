package org.example.todoweb.RequestDto;

import lombok.Getter;

@Getter
public class TodoRequest {
    //@NotNull
    private Long userId;
    //@NotNull
    private String title;
    //@NotNull
    private String description;
}
