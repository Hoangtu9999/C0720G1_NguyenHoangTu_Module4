package com.hoangtu.admin.repository;

import com.hoangtu.admin.entity.User;
import com.hoangtu.admin.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,String> {
    List<UserRole> findAllByUser(User user);
}
