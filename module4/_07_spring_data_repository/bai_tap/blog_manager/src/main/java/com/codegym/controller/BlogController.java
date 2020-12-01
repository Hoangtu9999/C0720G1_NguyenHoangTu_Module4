package com.codegym.controller;


import com.codegym.entity.BlogEntity;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;


@Controller
@RequestMapping({"", "/blog"})
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping({"/", "/home"})
    public String pageHome(Model model, @PageableDefault(size = 2) Pageable pageable,@RequestParam Optional<String> keyword) {
//        redirectAttributes.addFlashAttribute("message", "");
//
//        String keywordOld = "";
//        if (keyword.isPresent()) {
//            keywordOld = keyword.get();
//            model.addAttribute("blogList", blogService.findByNameContaining(pageable, keywordOld));
//        } else {
//            model.addAttribute("blogList", blogService.findAll(pageable));
//        }
//        model.addAttribute("keywordOld", keywordOld);
        return findPaginated(1,model);
    }

    @GetMapping("/form-create")
    public String formCreate(Model model) {
        model.addAttribute("blog", new BlogEntity());
        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute BlogEntity blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "more success!");
        return "redirect:/";
    }

    @GetMapping("/form-edit/{id}")
    public String formEdit(@PathVariable String id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "blog/edit";
    }

    @PostMapping("edit")
    public String edit(@ModelAttribute BlogEntity blogEntity, RedirectAttributes redirect) {
        blogService.edit(blogEntity);
        redirect.addFlashAttribute("message", "repaired successfully!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id, RedirectAttributes redirect) {
        blogService.delete(id);
        redirect.addFlashAttribute("message", "deleted successfully!");
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable String id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable int pageNo, Model model) {
        int pageSize = 2;

        Page<BlogEntity> page = blogService.findPaginated(pageNo, pageSize);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("blogEntityList", page.getContent());
        return "blog/index";
    }
    @GetMapping("/sort")
    public String sortByDate(Model model){
        model.addAttribute("blogList",blogService.findAllBlogAndSort());
        return "blog/sort";
    }
}
