package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.dto.user.UserCreateReq;
import com.example.demo.dto.user.UserIdDTO;
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
    public ResponseEntity<UserIdDTO> createUser(@RequestBody UserCreateReq userCreateReq)  throws ExecutionException, InterruptedException{
        try {
            UserIdDTO userIdDTO = userService.createUser(userCreateReq);
            return ResponseEntity.ok(userIdDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "회원 정보 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) {
        try {
            // userId를 사용하여 사용자 정보 조회
            User user = userService.getUserByUserId(userId);

            if (user != null) {
                // 사용자 정보를 찾았을 경우, 해당 정보를 응답으로 반환
                return ResponseEntity.ok(user);
            } else {
                // 사용자 정보를 찾지 못한 경우, 404 Not Found 반환
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            // 예외 발생 시, 500 Internal Server Error 반환
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
