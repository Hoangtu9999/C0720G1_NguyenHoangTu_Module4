package com.codegym.controller;

import com.codegym.entity.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"","/product"})
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String homePage(Model model){
       model.addAttribute("productList",productService.findAll());
        return "index";
    }
    @GetMapping("/form-create")
    public String formCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirect){
        productService.create(product);
        redirect.addFlashAttribute("message","more success!");
        return "redirect:/home";
    }
    @GetMapping("/form-edit/{id}")
    public String formEdit(Model model,@PathVariable Integer id){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product ,RedirectAttributes redirect){
        productService.edit(product.getId(),product);
        redirect.addFlashAttribute("message","repaired successfully!");
        return "redirect:/home";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id,RedirectAttributes redirect){
        productService.delete(id);
        redirect.addFlashAttribute("message","delete successfully!");
        return "redirect:/home";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "view";
    }
}
