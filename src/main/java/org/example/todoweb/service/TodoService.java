package org.example.todoweb.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.todoweb.entity.CommentEntity;
import org.example.todoweb.entity.TodoEntity;
import org.example.todoweb.entity.UserEntity;
import org.example.todoweb.repository.CommentRepository;
import org.example.todoweb.repository.TodoRepository;
import org.example.todoweb.repository.UserRepository;
import org.example.todoweb.requestDto.TodoRequest;
import org.example.todoweb.responseDto.TodoResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

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
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(()->new EntityNotFoundException("일정이 없습니다"));
        return new TodoResponse(todoEntity);
    }

    public TodoResponse create(TodoRequest todoRequest, UserEntity userEntity1) { //생성
        UserEntity userEntity2 = userRepository.findById(userEntity1.getId()).orElseThrow(()->new EntityNotFoundException("없는 회원입니다"));
        TodoEntity entity = todoRepository.save(new TodoEntity(userEntity2,todoRequest.getTitle(), todoRequest.getDescription()));
        return new TodoResponse(entity);
    }

    @Transactional//수정
    public TodoResponse update(Long id, TodoRequest todoRequest) {
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(()->new EntityNotFoundException("일정이 없습니다"));
        todoEntity.modify(todoRequest);
        return new TodoResponse(todoEntity);
    }

    @Transactional //삭제
    public void delete(Long id) {
        todoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("일정이 없습니다"));
        List<CommentEntity> comments = commentRepository.findByTodoEntity_Id(id);
        commentRepository.deleteAll(comments);
        todoRepository.deleteById(id);
    }
}
