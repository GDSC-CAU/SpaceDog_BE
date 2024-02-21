package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.user.UserCreateReq;
import com.example.demo.dto.user.UserIdDTO;
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

    public UserIdDTO createUser(UserCreateReq dto) throws ExecutionException, InterruptedException {
        User newUser = dto.toUser();
        String userId = userRepos.createUser(newUser);
        UserIdDTO res = new UserIdDTO();
        res.setUser_id(userId);
        return res;
    }

    public User getUserByUserId(String userId) throws ExecutionException, InterruptedException {
        User user = userRepos.getUserById(userId);
        return user;
    }
}
