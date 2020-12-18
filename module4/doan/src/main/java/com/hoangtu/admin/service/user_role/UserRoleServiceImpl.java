package com.hoangtu.admin.service.user_role;

import com.hoangtu.admin.entity.UserRole;
import com.hoangtu.admin.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    private UserRoleRepository repository;


    @Override
    public void save(UserRole userRole) {
        this.repository.save(userRole);
    }
}
