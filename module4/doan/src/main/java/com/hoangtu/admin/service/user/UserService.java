package com.hoangtu.admin.service.user;

import com.hoangtu.admin.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User save(User user);
}
