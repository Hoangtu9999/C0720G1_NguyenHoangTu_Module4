package com.codegym.controller;

import com.codegym.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {

    @Autowired
    private CalculateService calculateService;

    @GetMapping({"","/index"})
    public String home(){
        return "index";
    }
    @GetMapping("/calculate")
    public String calculate(@RequestParam double number1, @RequestParam double number2, @RequestParam String calculate, Model model){
        double result = calculateService.calculate(number1,number2,calculate);
            model.addAttribute("result",result);
        return "index";
    }
}
