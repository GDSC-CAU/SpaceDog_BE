package com.example.demo.controller;

import com.example.demo.domain.Sound;
import com.example.demo.domain.SoundLog;
import com.example.demo.service.SoundLogService;
import com.example.demo.service.SoundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping( value = "/soundLog",  produces = "application/json;charset=utf8")
@Tag(name = "소리 로그 API")
public class SoundLogController {
    private final SoundLogService soundLogService;

    public SoundLogController(SoundLogService soundLogService) {
        this.soundLogService = soundLogService;
    }

    @GetMapping
    public ResponseEntity<Object> getLogs() throws ExecutionException, InterruptedException {
        List<SoundLog> list = soundLogService.getSoundLogs();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "로그 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<List<SoundLog>> getSoundLogsByUserId(@PathVariable String userId) {
        try {
            List<SoundLog> soundLogs = soundLogService.getSoundLogsByUserId(userId);
            return ResponseEntity.ok(soundLogs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
