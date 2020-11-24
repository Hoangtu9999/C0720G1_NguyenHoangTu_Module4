package com.codegym.controllers;

import com.codegym.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {

    @Autowired
    private ConvertService convertService;

    @GetMapping({"","/home"})
    public String homePage(){
        return "/homepage";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam Double number1,  Model model){
        Double result = convertService.convert(number1);
        model.addAttribute("result",result);
        return "/result";
    }
}
