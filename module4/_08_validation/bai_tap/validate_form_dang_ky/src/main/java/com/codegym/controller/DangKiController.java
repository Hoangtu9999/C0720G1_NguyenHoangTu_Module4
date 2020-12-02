package com.codegym.controller;

import com.codegym.entity.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DangKiController {

    @GetMapping({"","/home"})
    public String homePage(Model model){
        model.addAttribute("registration", new Registration());
        return "index";
    }
    @PostMapping("/validation")
    public String validation(@Valid @ModelAttribute Registration registration, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "index";
        }else {
            return "result";
        }
    }
}
