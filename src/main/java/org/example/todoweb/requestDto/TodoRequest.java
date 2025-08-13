package org.example.todoweb.requestDto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class TodoRequest {
    @NotEmpty
    @Size(min = 1, max = 10) //할일 제목은 10글자 이내
    private String title;
    @NotEmpty
    private String description;
}
