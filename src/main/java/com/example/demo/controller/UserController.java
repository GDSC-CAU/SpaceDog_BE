package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.dto.user.UserCreateReq;
import com.example.demo.dto.user.UserCreateRes;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping( value = "/user",  produces = "application/json;charset=utf8")
@Tag(name = "사용자 API")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @Operation(summary = "회원 목록 조회")
    @GetMapping
    public ResponseEntity<Object> getUsers() throws ExecutionException, InterruptedException {
        List<User> list = userService.getUsers();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "회원 등록")
    @PostMapping("/register")
    public ResponseEntity<UserCreateRes> createUser(@RequestBody UserCreateReq userCreateReq)  throws ExecutionException, InterruptedException{
        try {
            UserCreateRes userCreateRes = userService.createUser(userCreateReq);
            return ResponseEntity.ok(userCreateRes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
