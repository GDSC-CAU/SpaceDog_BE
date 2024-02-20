package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    private final UserRepos userRepos;

    public UserService(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    public List<User> getUsers() throws ExecutionException, InterruptedException {
        return userRepos.getUsers();
    }
}
