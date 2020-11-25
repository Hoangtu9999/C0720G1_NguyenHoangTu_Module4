package com.codegym.controller;

import com.codegym.model.EmailObj;
import com.codegym.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {

//    @Autowired
//    private EmailService emailService;

    @GetMapping({"","/home-page"})
    public String homePage(Model model){
        model.addAttribute("emailObj",new EmailObj());
        return "home";
    }

    @GetMapping("/create")
    public String createNew(@ModelAttribute EmailObj emailObj, Model model){
//        emailService.sendEmail(emailObj);
//        redirectAttributes.addFlashAttribute("message","gửi thành công");
        model.addAttribute("languages",emailObj.getLanguages());
        model.addAttribute("pageSize",emailObj.getPageSize());
        model.addAttribute("spamsFilter",emailObj.getSpamsFilter());
        model.addAttribute("signature",emailObj.getSignature());
        return "result";
    }
}
