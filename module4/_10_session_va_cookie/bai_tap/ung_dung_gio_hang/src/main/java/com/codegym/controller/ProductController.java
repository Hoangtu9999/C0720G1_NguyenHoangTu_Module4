package com.codegym.controller;

import com.codegym.entity.ProductEntity;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping({"","/product"})
@SessionAttributes("cartList")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("cartList")
    public List<ProductEntity> setUpCart() {
        return new ArrayList<>();
    }


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
    public String addToCart(@ModelAttribute(value = "cartList") List<ProductEntity> cartList ,@PathVariable Integer id , RedirectAttributes redirect){
        ProductEntity productEntity = productService.findById(id);
        productEntity.setQuantity(productEntity.getQuantity() - 1);
        productService.save(productEntity);

        int i = 1;
        productEntity.setQuantity(i);
        cartList.add(productEntity);
        redirect.addFlashAttribute("message","Add to cart successfully!");
        return "redirect:/home";
    }
    @GetMapping("/cart")
    public String cart( Model model){//@ModelAttribute List<ProductEntity> productList,
//        model.addAttribute("listCart", productList);
        return "cart";
    }


    @GetMapping("/delete/{id}")
    public String delete(@ModelAttribute(value = "cartList") List<ProductEntity> productList , @PathVariable Integer id,RedirectAttributes redirect){
        ProductEntity productEntity = productService.findById(id);
        productEntity.setQuantity(productEntity.getQuantity() + 1);
        productService.save(productEntity);
        for (ProductEntity product: productList) {
            if (product.getProductId().equals(id)){
                productList.remove(product);
                redirect.addFlashAttribute("message", "delete successfully!");
                break;
            }
        }
    return "redirect:/home";
    }
}
