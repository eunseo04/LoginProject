package org.example.todoweb.Controller;


import lombok.RequiredArgsConstructor;
import org.example.todoweb.RequestDto.UserRequest;
import org.example.todoweb.ResponseDto.UserResponse;
import org.example.todoweb.Service.UserService;
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

    @GetMapping("/{userId}")
    public UserResponse findById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @PostMapping
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return userService.create(userRequest);
    }

    @PatchMapping("/{userId}")
    public UserResponse update(@PathVariable Long userId, @RequestBody UserRequest userRequest) {
        return userService.update(userId, userRequest);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        userService.delete(userId);
    }

}
