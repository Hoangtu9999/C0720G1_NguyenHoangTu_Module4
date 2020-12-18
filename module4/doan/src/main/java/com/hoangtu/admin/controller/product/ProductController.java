package com.hoangtu.admin.controller.product;


import com.hoangtu.admin.entity.Product;
import com.hoangtu.admin.service.producer.ProducerService;
import com.hoangtu.admin.service.product.ProductService;
import com.hoangtu.admin.service.product_type.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService categoryService;

    @Autowired
    private ProducerService producerService;


    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productList", this.productService.findAll());
        model.addAttribute("productTypeList", this.categoryService.findAll());
        model.addAttribute("producerList", this.producerService.findAll());
        return "/admin/product/index";
    }

    @PostMapping(value = "/create")
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult,
                RedirectAttributes redirect, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrorCreate", bindingResult.hasErrors());
            model.addAttribute("productList", this.productService.findAll());
            model.addAttribute("productTypeList", this.categoryService.findAll());
            model.addAttribute("producerList", this.producerService.findAll());
            return "/admin/product/index";
        }
        this.productService.save(product);
        redirect.addFlashAttribute("message", "More success!");
        return "redirect:/admin/product/home";
    }

    @PostMapping("/edit")
    public String modalEdit(@Valid @ModelAttribute Product product, BindingResult bindingResult
            , Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrorEdit", bindingResult.hasErrors());
            model.addAttribute("productList", this.productService.findAll());
            model.addAttribute("productTypeList", this.categoryService.findAll());
            model.addAttribute("producerList", this.producerService.findAll());
            return "/admin/product/index";
        }
        this.productService.save(product);
        model.addAttribute("message", "repaired successfully");
        return "redirect:/admin/product/home";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id , RedirectAttributes redirect){
        this.productService.delete(id);

        return "redirect:/admin/product/home";
    }

}
