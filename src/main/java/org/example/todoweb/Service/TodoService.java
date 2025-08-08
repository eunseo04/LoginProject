package org.example.todoweb.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.todoweb.Entity.TodoEntity;
import org.example.todoweb.Repository.TodoRepository;
import org.example.todoweb.RequestDto.ModifiedRequest;
import org.example.todoweb.RequestDto.TodoRequest;
import org.example.todoweb.ResponseDto.ModifiedResponse;
import org.example.todoweb.ResponseDto.TodoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional(readOnly = true) //전체조회
    public List<TodoResponse> findAll() {
        List<TodoResponse> todoResponseList = new ArrayList<>();
        for (TodoEntity entity : todoRepository.findAll()) {
            TodoResponse todoResponse = new TodoResponse(entity);
            todoResponseList.add(todoResponse);
        }
        return todoResponseList;
    }

    @Transactional(readOnly = true) //id조회
    public TodoResponse findById(Long id) {
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Todo not found"));
        TodoResponse todoResponse = new TodoResponse(todoEntity);
        return todoResponse;
    }

    public TodoResponse create(TodoRequest todoRequest) { //생성
        TodoEntity entity = todoRepository.save(new TodoEntity(todoRequest.getTitle(), todoRequest.getDescription()));
        return new TodoResponse(entity);
    }

    @Transactional//수정
    public ModifiedResponse update(Long id, ModifiedRequest modifiedRequest) {
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Todo not found"));
        todoEntity.modify(modifiedRequest);
        return new ModifiedResponse(todoEntity);
    }

    @Transactional //삭제
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
