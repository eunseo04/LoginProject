package org.example.todoweb.requestDto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.hibernate.validator.constraints.Range;

@Getter
public class TodoRequest {
    @NotEmpty
    private Long userId;
    @NotEmpty
    @Range(min = 1, max = 10) //할일 제목은 10글자 이내
    private String title;
    @NotEmpty
    private String description;
}
