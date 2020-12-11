package com.codegym.service;

import com.codegym.entity.AppUser;
import com.codegym.entity.UserRole;
import com.codegym.repository.AppRoleRepository;
import com.codegym.repository.AppUserRepository;
import com.codegym.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = this.appUserRepository.findByUserName(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
        List<UserRole> userRoleList = this.userRoleRepository.findByAppUser(appUser);

        List<GrantedAuthority> authorityList = new ArrayList<>();

        if (userRoleList != null) {
            for (UserRole userRole : userRoleList) {
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                authorityList.add(authority);
            }
        }
        UserDetails userDetails = new User(appUser.getUserName(), appUser.getEncrytedPassword(), authorityList);
        return userDetails;
    }
}
