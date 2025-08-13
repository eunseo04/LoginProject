package org.example.todoweb.controller;


import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.todoweb.Const;
import org.example.todoweb.entity.UserEntity;
import org.example.todoweb.requestDto.UserRequest;
import org.example.todoweb.responseDto.UserResponse;
import org.example.todoweb.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/signIn")
    public ResponseEntity signIn(@Valid @RequestBody UserRequest userRequest, HttpServletRequest request) {
        return userService.login(userRequest, request);
    }

    @PostMapping("/signUp")
    public UserResponse signUp(@Valid @RequestBody UserRequest userRequest, HttpServletRequest request) {
        return userService.create(userRequest, request);
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request) {
        // 로그인하지 않으면 HttpSession이 null로 반환된다.
        HttpSession session = request.getSession(false);
        // 세션이 존재하면 -> 로그인이 된 경우
        if (session != null) {
            session.invalidate(); // 해당 세션(데이터)을 삭제한다.
        }
    }

    @PatchMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @Valid @RequestBody UserRequest userRequest, @SessionAttribute(name = Const.LOGIN_USER, required = false) UserEntity loginUser) {
        // session에 loginUser가 없으면 에러 문구 출력
        if (loginUser == null) {
            throw new EntityNotFoundException("로그인 해주세요");
        }
        return userService.update(id, userRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

}
