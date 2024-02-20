package com.example.demo.controller;

import com.example.demo.domain.Sound;
import com.example.demo.service.SoundService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping( value = "/sound",  produces = "application/json;charset=utf8")
@Tag(name = "소리 종류 API")
public class SoundController {
    private final SoundService soundService;

    public SoundController(SoundService soundService) {
        this.soundService = soundService;
    }

    @GetMapping
    public ResponseEntity<Object> getUsers() throws ExecutionException, InterruptedException {
        List<Sound> list = soundService.getUsers();
        return ResponseEntity.ok().body(list);
    }
}
