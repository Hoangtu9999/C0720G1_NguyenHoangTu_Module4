package com.codegym.controller;

import com.codegym.entity.CategoryEntity;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping( "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping({"/", "/home"})
    public String pageHome(Model model) {
        model.addAttribute("categoryList",categoryService.findAll());
        return "category/index";
    }

    @GetMapping("/form-create")
    public String formCreate(Model model) {
        model.addAttribute("category", new CategoryEntity());
        return "category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute CategoryEntity category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("message", "more success!");
        return "redirect:/category/";
    }

    @GetMapping("/form-edit/{id}")
    public String formEdit(@PathVariable String id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute CategoryEntity category, RedirectAttributes redirect) {
        categoryService.edit(category);
        redirect.addFlashAttribute("message", "repaired successfully!");
        return "redirect:/category/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, RedirectAttributes redirect) {
        categoryService.delete(id);
        redirect.addFlashAttribute("message", "deleted successfully!");
        return "redirect:/category/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable String id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/view";
    }

//    @GetMapping("/list-category/{id}")
//    public String listCategory(@PathVariable String id,Model model){
//
//    }

}
