package org.example.todoweb.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.todoweb.Const;
import org.example.todoweb.PasswordEncoder;
import org.example.todoweb.entity.CommentEntity;
import org.example.todoweb.entity.TodoEntity;
import org.example.todoweb.entity.UserEntity;
import org.example.todoweb.repository.CommentRepository;
import org.example.todoweb.repository.TodoRepository;
import org.example.todoweb.repository.UserRepository;
import org.example.todoweb.requestDto.UserRequest;
import org.example.todoweb.responseDto.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public List<UserResponse> findAll() { //전체회원조회
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserResponse> todoResponses = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            todoResponses.add(new UserResponse(userEntity));
        }
        return todoResponses;
    }

    @Transactional(readOnly = true)
    public ResponseEntity login(UserRequest userRequest, HttpServletRequest request) { //로그인
        UserEntity userEntity = userRepository.findByEmail(userRequest.getEmail()).orElseThrow(() -> new EntityNotFoundException("없는 회원입니다") );
        if (passwordEncoder.matches(userRequest.getPassword(), userEntity.getPassword())) {
            HttpSession session = request.getSession(); // 신규 세션 생성, JSESSIONID 쿠키 발급
            session.setAttribute(Const.LOGIN_USER, userEntity);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    @Transactional(readOnly = true) //회원조회
    public UserResponse findById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("없는 회원입니다") );
        return new UserResponse(userEntity);
    }

    @Transactional //회원가입
    public UserResponse create(UserRequest userRequest, HttpServletRequest request) {
        UserEntity entity = new UserEntity(userRequest.getName(), passwordEncoder.encode(userRequest.getPassword()), userRequest.getEmail());
        HttpSession session = request.getSession(); // 신규 세션 생성, JSESSIONID 쿠키 발급
        UserEntity userEntity = userRepository.save(entity);
        session.setAttribute(Const.LOGIN_USER, userEntity); // 서버 메모리에 세션 저장
        return new UserResponse(userEntity);
    }

    @Transactional //회원정보수정
    public UserResponse update(Long id, UserRequest userRequest) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("없는 회원입니다") );
        userEntity.update(userRequest.getName(), userRequest.getEmail(), passwordEncoder.encode(userRequest.getPassword()));
        return new UserResponse(userEntity);
    }

    @Transactional //회원삭제
    public void delete(Long id) {
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("회원이 없습니다"));
        List<CommentEntity> comments = commentRepository.findByTodoEntity_UserEntity_Id(id);
        List<TodoEntity> todos = todoRepository.findByUserEntityId(id);
        commentRepository.deleteAll(comments);
        todoRepository.deleteAll(todos);
        userRepository.deleteById(id);
    }
}
