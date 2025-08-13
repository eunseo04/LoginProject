package org.example.todoweb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.todoweb.entity.UserEntity;
import org.example.todoweb.requestDto.CommentRequest;
import org.example.todoweb.responseDto.CommentResponse;
import org.example.todoweb.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comments")
    public List<CommentResponse> findAll() {
        return commentService.findAll();
    }

    @GetMapping("/user/{userId}/comments")
    public List<CommentResponse> findByUserId(@PathVariable Long userId) {
        return commentService.findByUserId(userId); //수정
    }

    @PostMapping("/todo/{todoId}/comments")
    public CommentResponse create(@PathVariable Long todoId, @Valid @RequestBody CommentRequest commentRequest, @SessionAttribute UserEntity userEntity) {
        return commentService.create(todoId, commentRequest, userEntity);
    }

    @PatchMapping("/comments/{commentId}")
    public CommentResponse update(@PathVariable Long commentId, @Valid @RequestBody CommentRequest commentRequest) {
        return commentService.update(commentId, commentRequest);
    }

    @DeleteMapping("/comments/{commentId}")
    public void delete(@PathVariable Long commentId) {
        commentService.delete(commentId);
    }
}
