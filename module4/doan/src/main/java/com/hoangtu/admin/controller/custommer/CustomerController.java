package com.hoangtu.admin.controller.custommer;

import com.hoangtu.admin.entity.Customer;
import com.hoangtu.admin.service.customer.CustomerService;
import com.hoangtu.admin.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/admin/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;


    @GetMapping("/home")
    public String homePage(Model model,
                           @PageableDefault(size = 2)Pageable pageable, @RequestParam Optional<String> keyword){
        String keywordAfterCheck = "";
        if (!keyword.isPresent()){
            model.addAttribute("customerList", this.customerService.findAll(pageable));
        }else {
            keywordAfterCheck = keyword.get();
            model.addAttribute("customerList", this.customerService.findByNameContainingOrEmailContaining(keywordAfterCheck,keywordAfterCheck,pageable));
        }
        model.addAttribute("keywordAfterCheck", keywordAfterCheck);
        model.addAttribute("customer", new Customer());
//        model.addAttribute("customerList", this.customerService.findAll());
        model.addAttribute("userList", this.userService.findAll());
        return "/admin/customer/index";
    }

    @PostMapping(value = "/create")
    public String create(@Valid @ModelAttribute Customer customer, BindingResult bindingResult,
                         @PageableDefault(size = 2)Pageable pageable, RedirectAttributes redirect, Model model) {
        new Customer().validate(customer, bindingResult);

        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrorCreate", bindingResult.hasErrors());
            model.addAttribute("userList", this.userService.findAll());
            model.addAttribute("customerList", this.customerService.findAll(pageable));
            return "/admin/customer/index";
        }
        this.customerService.save(customer);
        redirect.addFlashAttribute("message1", "More success!");
        return "redirect:/admin/customer/home";
    }
    @PostMapping("/edit")
    public String modalEdit(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirect,
           @PageableDefault(size = 2)Pageable pageable , Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("hasErrorEdit", bindingResult.hasErrors());
            model.addAttribute("userList", this.userService.findAll());
            model.addAttribute("customerList", this.customerService.findAll(pageable));
            return "/admin/customer/index";
        }
        this.customerService.save(customer);
        redirect.addFlashAttribute("message1", "Repaired successfully!");
        return "redirect:/admin/customer/home";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id ){
        this.customerService.delete(id);

        return "redirect:/admin/customer/home";
    }

    @GetMapping("/search")
    public String search(Model model,
                           @PageableDefault(size = 2)Pageable pageable, @RequestParam Optional<String> keyword
//                            , @RequestParam Optional<String> type
    ){
        //Search Select option
//        String keywordAfterCheck1 = "";
//        String keywordAfterCheck2 = "";
//        if (!keyword.isPresent() && !type.isPresent()){
//            model.addAttribute("customerList", this.customerService.findAll(pageable));
//        }else {
//            keywordAfterCheck1 = keyword.get();
//            keywordAfterCheck2 = type.get();
//            switch (keywordAfterCheck2){
//                case "name":
//                    model.addAttribute("customerList", this.customerService.searchByName(keywordAfterCheck1,pageable));
//                    break;
//                case "address":
//                    model.addAttribute("customerList",this.customerService.searchByAddress(keywordAfterCheck1,pageable));
//                    break;
//                default:
//                    model.addAttribute("customerList", this.customerService.findAll(pageable));
//                    break;
//            }
//            Page<Customer> customerList = this.customerService.findByNameContainingOrEmailContaining(keywordAfterCheck,keywordAfterCheck,pageable);
//            if (customerList.isEmpty()){
//                model.addAttribute("message","Not found!");
//                model.addAttribute("customerList", this.customerService.findAll(pageable));
//            }else {
//                model.addAttribute("customerList", this.customerService.findByNameContainingOrEmailContaining(keywordAfterCheck,keywordAfterCheck,pageable));
//            }

        //search theo khoảng

//        if (!search.isPresent() && !type.isPresent() && !startDate.isPresent() &&!endDate.isPresent()) {
//            model.addAttribute("listCustomer", customerService.findAllPage(pageable));
//        } else {
//            if(!search.isPresent()&&!type.isPresent()){
//                startDateCheck = startDate.get();
//                endDateCheck = endDate.get();
//                model.addAttribute("listCustomer", customerService.findAllByDate(startDateCheck,endDateCheck,pageable));
//            }else {
//                nameAfterCheck = search.get();
//                typeAfterCheck = type.get();
//                switch (typeAfterCheck){
//                    case "name":
//                        model.addAttribute("listCustomer", this.customerService.findAllByCustomerNameContaining(nameAfterCheck, pageable));
//                        break;
//                    case"address":
//                        model.addAttribute("listCustomer",this.customerService.findAllByCustomerAddressContaining(nameAfterCheck,pageable));
//                        break;
//                    case "id":
//                        model.addAttribute("listCustomer",customerService.findAllByCustomerId(  Integer.parseInt(nameAfterCheck),pageable));
//                        break;
//                }
//            }
//        }
        String keywordAfterCheck = "";
        if (!keyword.isPresent()){
            model.addAttribute("customerList",this.customerService.findAll(pageable));
        }else {
            keywordAfterCheck = keyword.get();
            Page<Customer> customerList = this.customerService.findByNameContainingOrEmailContaining(keywordAfterCheck,keywordAfterCheck,pageable);
            if (customerList.isEmpty()){
                model.addAttribute("message","Not found!");
                model.addAttribute("customerList", this.customerService.findAll(pageable));
            }else {
                model.addAttribute("customerList", this.customerService.findByNameContainingOrEmailContaining(keywordAfterCheck,keywordAfterCheck,pageable));
            }
        }
        model.addAttribute("keywordAfterCheck", keywordAfterCheck);
//        model.addAttribute("keywordAfterCheck1", keywordAfterCheck);
//        model.addAttribute("keywordAfterCheck2", keywordAfterCheck);
        model.addAttribute("customer", new Customer());
        model.addAttribute("userList", this.userService.findAll());
        return "/admin/customer/index";
    }


}


















