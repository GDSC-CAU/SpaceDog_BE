package com.example.demo.service;

import com.example.demo.domain.Locate;
import com.example.demo.domain.SoundLog;
import com.example.demo.repository.LocateRepos;
import com.example.demo.repository.SoundLogRepos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class LocateService {
    private final LocateRepos locateRepos;

    public LocateService(LocateRepos soundRepos) {
        this.locateRepos = soundRepos;
    }

    public List<Locate> getLocates() throws ExecutionException, InterruptedException {
        return locateRepos.getLocates();
    }
}
