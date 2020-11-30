package com.codegym.tao_ung_dung_blog.controller;

import com.codegym.tao_ung_dung_blog.entity.Blog;
import com.codegym.tao_ung_dung_blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"","/blog"})
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/home")
    public String pageHome(Model model){
        model.addAttribute("blogList",blogService.findAll());
        return "views/index";
    }
    @GetMapping("/form-create")
    public String formCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "views/create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("message","more success!");
        return "redirect:/home";
    }

    @GetMapping("/form-edit/{id}")
    public String formEdit(@PathVariable String id ,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "views/edit";
    }
    @PostMapping("edit")
    public String edit(@ModelAttribute Blog blog,RedirectAttributes redirect){
        blogService.edit(blog);
        redirect.addFlashAttribute("message","repaired successfully!");
        return "redirect:/home";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, RedirectAttributes redirect){
        blogService.delete(id);
        redirect.addFlashAttribute("message","deleted successfully!");
        return "redirect:/home";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable String id,Model model){
        model.addAttribute("blog",blogService.findById(id));
        return "views/view";
    }
}
