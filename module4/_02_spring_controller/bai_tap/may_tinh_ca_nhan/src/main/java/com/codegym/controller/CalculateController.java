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

        double result = 0;
        switch (calculate){
            case "+":
                 result = calculateService.plus(number1,number2);
                break;
            case "-":
                result = calculateService.minus(number1,number2);
                break;
            case "*":
                result = calculateService.multiply(number1,number2);
                break;
            case "/":
                result = calculateService.share(number1,number2);
                break;
        }
            model.addAttribute("result",result);
        return "index";
    }
}
