package com.hoangtu.admin.service.user.impl;

import com.hoangtu.admin.entity.User;
import com.hoangtu.admin.repository.UserRepository;
import com.hoangtu.admin.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    public User save(User user) {
       return this.repository.save(user);
    }
}
