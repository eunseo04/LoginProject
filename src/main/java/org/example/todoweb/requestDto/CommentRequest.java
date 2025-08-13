package org.example.todoweb.requestDto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;

@Getter
public class CommentRequest {
    @NotEmpty
    private String comment;
}
