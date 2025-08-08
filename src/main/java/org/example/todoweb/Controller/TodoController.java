package org.example.todoweb.Controller;

import lombok.RequiredArgsConstructor;
import org.example.todoweb.RequestDto.ModifiedRequest;
import org.example.todoweb.RequestDto.TodoRequest;
import org.example.todoweb.ResponseDto.ModifiedResponse;
import org.example.todoweb.ResponseDto.TodoResponse;
import org.example.todoweb.Service.TodoService;
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

    @PostMapping
    public TodoResponse create(@RequestBody TodoRequest todoRequest) {
        return todoService.create(todoRequest);
    }

    @PatchMapping
    public ModifiedResponse update(@RequestParam Long id, @RequestBody ModifiedRequest modifiedRequest) {
        return todoService.update(id, modifiedRequest);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        todoService.delete(id);
    }
}
