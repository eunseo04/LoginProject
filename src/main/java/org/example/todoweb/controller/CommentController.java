package org.example.todoweb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.todoweb.requestDto.CommentRequest;
import org.example.todoweb.responseDto.CommentResponse;
import org.example.todoweb.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<CommentResponse> allComments() {
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public List<CommentResponse> findByUserId(@PathVariable Long id) {
        return commentService.findByUserId(id); //수정
    }

    @PostMapping("/{id}")
    public CommentResponse create(@PathVariable Long id, @Valid @RequestBody CommentRequest commentRequest) {
        return commentService.create(id, commentRequest);
    }

    @PatchMapping("/{id}")
    public CommentResponse update(@PathVariable Long id, @Valid @RequestBody CommentRequest commentRequest) {
        return commentService.update(id, commentRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        commentService.delete(id);
    }
}
