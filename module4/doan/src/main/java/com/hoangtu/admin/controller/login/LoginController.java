package com.hoangtu.admin.controller.login;

import com.hoangtu.admin.entity.Role;
import com.hoangtu.admin.entity.User;
import com.hoangtu.admin.entity.UserRole;
import com.hoangtu.admin.service.user.UserService;
import com.hoangtu.admin.service.user_role.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/login")
    public String pageLogin(Model model){
        model.addAttribute("user", new User());
        return "/admin/login/login";
    }

    @GetMapping("/403")
    public String page403(){
        return "admin/403";
    }

    @PostMapping("/signUp")
    public String signIn(@ModelAttribute User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user = this.userService.save(user);
        UserRole userRole = new UserRole(user.getId(), "1");

        this.userRoleService.save(userRole);
        return "redirect:/admin/login";
    }
}
