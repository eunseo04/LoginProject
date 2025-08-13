package org.example.todoweb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.todoweb.entity.CommentEntity;
import org.example.todoweb.entity.TodoEntity;
import org.example.todoweb.entity.UserEntity;
import org.example.todoweb.repository.CommentRepository;
import org.example.todoweb.repository.TodoRepository;
import org.example.todoweb.repository.UserRepository;
import org.example.todoweb.requestDto.CommentRequest;
import org.example.todoweb.responseDto.CommentResponse;
import org.example.todoweb.responseDto.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<CommentResponse> findAll() {
        List<CommentResponse> commentResponseList = new ArrayList<>();
        for (CommentEntity commentEntity : commentRepository.findAll()) {
            commentResponseList.add(new CommentResponse(commentEntity));
        }
        return commentResponseList;
    }

    @Transactional(readOnly = true)
    public List<CommentResponse> findByUserId(Long id) {
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("없는 회원입니다"));
        List<CommentResponse> list = new ArrayList<>();
        for (CommentEntity entity :commentRepository.findByUserId(id)){
            list.add(new CommentResponse(entity));
        }
        return list;
    }

    @Transactional
    public CommentResponse create(Long id, CommentRequest commentRequest) {
        TodoEntity todoEntity = todoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("일정이 없습니다"));
        CommentEntity entity = commentRepository.save(new CommentEntity(commentRequest.getComment(), todoEntity));
        return new CommentResponse(entity);
    }

    @Transactional
    public CommentResponse update(Long id, CommentRequest commentRequest) {
        CommentEntity commentEntity = commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("댓글이 없습니다"));
        commentEntity.update(commentRequest.getComment());
        return new CommentResponse(commentEntity);
    }

    @Transactional
    public void delete(Long id) {
        commentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("댓글이 없습니다"));
        commentRepository.deleteById(id);
    }
}
