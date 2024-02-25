package com.example.demo.service;

import com.example.demo.domain.Locate;
import com.example.demo.domain.Sound;
import com.example.demo.dto.locate.LocateInfoDTO;
import com.example.demo.dto.sound.SoundInfoDTO;
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

    public List<Sound> getSounds() throws ExecutionException, InterruptedException {
        return soundRepos.getSounds();
    }

    public String createSound(SoundInfoDTO dto, String userId) throws ExecutionException, InterruptedException {
        Sound s = dto.toSound(userId);
        String locateId = soundRepos.createSound(s);
        return locateId;
    }
}
