package com.example.demo.controller;

import com.example.demo.domain.Sound;
import com.example.demo.dto.locate.LocateInfoDTO;
import com.example.demo.dto.sound.SoundInfoDTO;
import com.example.demo.service.SoundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping( value = "/sound",  produces = "application/json;charset=utf8")
@Tag(name = "소리 상태 API")
public class SoundController {
    private final SoundService soundService;

    public SoundController(SoundService soundService) {
        this.soundService = soundService;
    }

    @GetMapping
    public ResponseEntity<Object> getSounds() throws ExecutionException, InterruptedException {
        List<Sound> list = soundService.getSounds();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "소리 등록")
    @PostMapping("/{userId}")
    public ResponseEntity<String> createLocate(@PathVariable String userId, @RequestBody SoundInfoDTO soundInfoDTO) {
        try {
            // SoundLog를 생성하고 해당 ID를 반환
            String soundId = soundService.createSound(soundInfoDTO, userId);
            return ResponseEntity.ok().body(soundId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
