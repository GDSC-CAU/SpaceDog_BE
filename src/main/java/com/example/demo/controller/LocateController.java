package com.example.demo.controller;

import com.example.demo.domain.Locate;
import com.example.demo.domain.Sound;
import com.example.demo.service.LocateService;
import com.example.demo.service.SoundService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping( value = "/locates",  produces = "application/json;charset=utf8")
@Tag(name = "위치 상태 API")
public class LocateController {
    private final LocateService locateService;

    public LocateController(LocateService locateervice) {
        this.locateService = locateervice;
    }

    @GetMapping
    public ResponseEntity<Object> getLocates() throws ExecutionException, InterruptedException {
        List<Locate> list = locateService.getLocates();
        return ResponseEntity.ok().body(list);
    }
}
