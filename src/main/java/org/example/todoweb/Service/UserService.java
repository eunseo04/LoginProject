package org.example.todoweb.Service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.todoweb.Entity.UserEntity;
import org.example.todoweb.Repository.TodoRepository;
import org.example.todoweb.Repository.UserRepository;
import org.example.todoweb.RequestDto.UserRequest;
import org.example.todoweb.ResponseDto.TodoResponse;
import org.example.todoweb.ResponseDto.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserResponse> findAll() { //전체 조회
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserResponse> todoResponses = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            todoResponses.add(new UserResponse(userEntity));
        }
        return todoResponses;
    }

    @Transactional(readOnly = true) //id 조회
    public UserResponse findById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found") );
        UserResponse todoResponse = new UserResponse(userEntity);
        return todoResponse;
    }

    @Transactional //생성
    public UserResponse create(UserRequest userRequest) {
        UserEntity entity = new UserEntity(userRequest.getName(), userRequest.getPassword(), userRequest.getEmail());
        UserEntity userEntity = userRepository.save(entity);
        return new UserResponse(userEntity);
    }

    @Transactional //수정
    public UserResponse update(Long id, UserRequest userRequest) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found") );
        userEntity.update(userRequest.getName(), userRequest.getEmail());
        return new UserResponse(userEntity);
    }

    @Transactional //삭제
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
