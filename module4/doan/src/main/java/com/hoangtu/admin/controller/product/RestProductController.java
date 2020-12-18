package com.hoangtu.admin.controller.product;

import com.hoangtu.admin.entity.Product;
import com.hoangtu.admin.service.producer.ProducerService;
import com.hoangtu.admin.service.product.ProductService;
import com.hoangtu.admin.service.product_type.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService categoryService;

    @Autowired
    private ProducerService producerService;


    @GetMapping("/product/home")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productAdd", new Product());
        modelAndView.addObject("productEdit", new Product());
        modelAndView.addObject("productList", this.productService.findAll());
        modelAndView.addObject("productTypeList", this.categoryService.findAll());
        modelAndView.addObject("producerList", this.producerService.findAll());
        return new ModelAndView("/admin/product/index");
    }

    @GetMapping("/product/modal-edit/{id}")
    public ResponseEntity<Product> getProductEdit(@PathVariable String id) {
        Product product = this.productService.findById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }



}
