package com.codegym.controller;

import com.codegym.entity.ProductEntity;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping({"","/product"})
@SessionAttributes(value = "productList")
public class ProductController {

    @Autowired
    private ProductService productService;



    @GetMapping("/home")
    public String pageHome(Model model){
        model.addAttribute("productList", productService.findAll());
        return "index";
    }

    @GetMapping("/formView/{id}")
    public String formView(@PathVariable Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "view";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@SessionAttribute(value = "productList") List<ProductEntity> productList ,@PathVariable Integer id , RedirectAttributes redirect){
        ProductEntity productEntity = productService.findById(id);
        productEntity.setQuantity(-1);
        productList.add(productEntity);
        redirect.addFlashAttribute("message","Add to cart successfully!");
        return "redirect:/home";
    }
}
