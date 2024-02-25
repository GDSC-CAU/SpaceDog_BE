package com.example.demo.controller;

import com.example.demo.domain.Locate;
import com.example.demo.domain.Sound;
import com.example.demo.domain.SoundLog;
import com.example.demo.dto.locate.LocateInfoDTO;
import com.example.demo.dto.soundLog.LogIdDTO;
import com.example.demo.dto.soundLog.SoundDTO;
import com.example.demo.dto.user.UserCreateReq;
import com.example.demo.dto.user.UserIdDTO;
import com.example.demo.service.LocateService;
import com.example.demo.service.SoundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping( value = "/locates",  produces = "application/json;charset=utf8")
@Tag(name = "위치 상태 API")
public class LocateController {
    private final LocateService locateService;

    public LocateController(LocateService locateService) {
        this.locateService = locateService;
    }

    @GetMapping
    public ResponseEntity<Object> getLocates() throws ExecutionException, InterruptedException {
        List<Locate> list = locateService.getLocates();
        return ResponseEntity.ok().body(list);
    }

    @Operation(summary = "위치 등록")
    @PostMapping("/{userId}")
    public ResponseEntity<String> createLocate(@PathVariable String userId, @RequestBody LocateInfoDTO locateInfoDTO) {
        try {
            // SoundLog를 생성하고 해당 ID를 반환
            String locateId = locateService.createLocate(locateInfoDTO, userId);
            return ResponseEntity.ok().body(locateId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "위치 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<Locate> getSoundLogsByUserId(@PathVariable String userId) {
        try {
            System.out.println("dd");
            Locate locate = locateService.getLatestLocate(userId);
            return ResponseEntity.ok(locate);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
