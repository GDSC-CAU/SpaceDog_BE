package com.example.demo.service;

import com.example.demo.domain.Locate;
import com.example.demo.domain.SoundLog;
import com.example.demo.domain.User;
import com.example.demo.dto.locate.LocateInfoDTO;
import com.example.demo.dto.user.UserCreateReq;
import com.example.demo.dto.user.UserIdDTO;
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

    public String createLocate(LocateInfoDTO dto, String userId) throws ExecutionException, InterruptedException {
        Locate l = new Locate();
        l = dto.toLocate(userId);
        String locateId = locateRepos.createLocate(l);
        return locateId;
    }
}
