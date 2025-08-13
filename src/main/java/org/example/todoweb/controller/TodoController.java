package org.example.todoweb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.todoweb.Const;
import org.example.todoweb.entity.UserEntity;
import org.example.todoweb.requestDto.TodoRequest;
import org.example.todoweb.responseDto.TodoResponse;
import org.example.todoweb.service.TodoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public List<TodoResponse> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/{todoId}")
    public TodoResponse findById(@PathVariable Long todoId) {
        return todoService.findById(todoId);
    }

    @PostMapping
    public TodoResponse create(@Valid @RequestBody TodoRequest todoRequest, @SessionAttribute(name = Const.LOGIN_USER, required = false) UserEntity loginUser) {
        return todoService.create(todoRequest, loginUser);
    }

    @PatchMapping("/{todoId}")
    public TodoResponse update(@PathVariable Long todoId, @Valid @RequestBody TodoRequest todoRequest) {
        return todoService.update(todoId, todoRequest);
    }

    @DeleteMapping("/{todoId}")
    public void delete(@PathVariable Long todoId) {
        todoService.delete(todoId);
    }
}
