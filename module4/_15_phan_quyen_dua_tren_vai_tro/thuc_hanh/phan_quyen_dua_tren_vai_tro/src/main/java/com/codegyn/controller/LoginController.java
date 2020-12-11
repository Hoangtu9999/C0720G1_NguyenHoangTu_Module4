package com.codegyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = "userLogin")
public class LoginController {

//    @GetMapping(value = "/login")
//    public String goLogin(Model model,
//                          @CookieValue(value = "usernameC", defaultValue = "") String username,
//                          @CookieValue(value = "passwordC", defaultValue = "") String password) {
//        model.addAttribute("userLogin", new User(username, password));
//        return "login";
//    }

    @GetMapping(value = "/login")
    public String goLogin() {
        return "login";
    }

//    @PostMapping(value = "/login")
//    public String login(@ModelAttribute(value = "userLogin") User user, HttpServletResponse response) {
//        Cookie cookieUsername = new Cookie("usernameC", user.getUsername());
//        Cookie cookiePassword = new Cookie("passwordC", user.getPassword());
//        cookieUsername.setMaxAge(30);
//        cookiePassword.setMaxAge(30);
//
//        response.addCookie(cookieUsername);
//        response.addCookie(cookiePassword);
//
//        return "redirect:/";
//    }

    @GetMapping("/403")
    public String go403() {
        return "403";
    }
}
