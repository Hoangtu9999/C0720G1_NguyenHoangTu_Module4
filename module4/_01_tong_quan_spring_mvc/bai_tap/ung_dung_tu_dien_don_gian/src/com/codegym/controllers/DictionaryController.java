package com.codegym.controllers;

import com.codegym.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping({"","/home"})
    public String homePage(){
        return "home-page";
    }
    @GetMapping("/search")
    public String search(@RequestParam String english, Model model){
        String result = dictionaryService.search(english);
        model.addAttribute("result",result);
        return "result";
    }
}
