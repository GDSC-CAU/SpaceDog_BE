package com.example.demo.service;

import com.example.demo.domain.Sound;
import com.example.demo.repository.SoundRepos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class SoundService {
    private final SoundRepos soundRepos;

    public SoundService(SoundRepos soundRepos) {
        this.soundRepos = soundRepos;
    }

    public List<Sound> getUsers() throws ExecutionException, InterruptedException {
        return soundRepos.getUsers();
    }
}
