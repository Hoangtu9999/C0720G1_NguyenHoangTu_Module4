package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String index(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList",productList);
        return "index";
    }
    @GetMapping("/product/form-create")
    public String formCreate(Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping("/product/create")
    public String create(@ModelAttribute Product product, RedirectAttributes redirect){
    product.setId((int) (Math.random() * 100));
    productService.create(product);
    redirect.addFlashAttribute("message","more success!");
    return "redirect:/";
    }
    @GetMapping("/product/{id}/form-edit")
    public String formEdit(@PathVariable Integer id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }
    @PostMapping("/product/edit")
    public String edit(@ModelAttribute Product product, RedirectAttributes redirect){
        productService.edit(product.getId() ,product);
        redirect.addFlashAttribute("message","repaired successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable Integer id,RedirectAttributes redirect){
        productService.delete(id);
        redirect.addFlashAttribute("message","deleted successfully!");
        return "redirect:/";
    }
    @GetMapping("/product/{id}/form-view")
    public String formView(@PathVariable Integer id, RedirectAttributes redirect,Model model){
        model.addAttribute("product",productService.findById(id));
        return "view";
    }
}
