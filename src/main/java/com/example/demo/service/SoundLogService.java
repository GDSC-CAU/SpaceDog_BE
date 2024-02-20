package com.example.demo.service;

import com.example.demo.domain.Sound;
import com.example.demo.domain.SoundLog;
import com.example.demo.repository.SoundLogRepos;
import com.example.demo.repository.SoundRepos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class SoundLogService {
    private final SoundLogRepos soundLogRepos;

    public SoundLogService(SoundLogRepos soundRepos) {
        this.soundLogRepos = soundRepos;
    }

    public List<SoundLog> getSoundLogs() throws ExecutionException, InterruptedException {
        return soundLogRepos.getSoundLogs();
    }
}
