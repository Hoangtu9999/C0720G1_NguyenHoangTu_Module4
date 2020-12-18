package com.hoangtu.admin.service.user.impl;


import com.hoangtu.admin.entity.User;
import com.hoangtu.admin.entity.UserRole;
import com.hoangtu.admin.repository.UserRepository;
import com.hoangtu.admin.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        List<UserRole> userRoleList = this.userRoleRepository.findAllByUser(user);

        List<GrantedAuthority> authorityList = new ArrayList<>();

        if (userRoleList != null) {
            for (UserRole userRole : userRoleList) {
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getRole().getName());
                authorityList.add(authority);
            }
        }
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorityList);
        return userDetails;
    }
}
