package com.codegym.controller;

import com.codegym.entity.MyCounterEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("mycounter")
public class CounterController {

    /* add MyCounter in model attribute */
    @ModelAttribute("mycounter")
    public MyCounterEntity setUpCounter() {
        return new MyCounterEntity();
    }

    @GetMapping("/")
    public String get(@ModelAttribute("mycounter") MyCounterEntity myCounterEntity) {
        myCounterEntity.increment();
        return "index";
    }
}