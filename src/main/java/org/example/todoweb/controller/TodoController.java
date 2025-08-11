package org.example.todoweb.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/{id}")
    public TodoResponse findById(@Valid @PathVariable Long id) {
        return todoService.findById(id);
    }

    @PostMapping
    public TodoResponse create(@Valid @RequestBody TodoRequest todoRequest) {
        return todoService.create(todoRequest);
    }

    @PatchMapping
    public TodoResponse update(@Valid @RequestParam Long id, @Valid @RequestBody TodoRequest todoRequest) {
        return todoService.update(id, todoRequest);
    }

    @DeleteMapping
    public void delete(@Valid @RequestParam Long id) {
        todoService.delete(id);
    }
}
