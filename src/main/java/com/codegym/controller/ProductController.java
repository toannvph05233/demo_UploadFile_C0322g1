package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.CategoryService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/products")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", productService.getAll());
        return modelAndView;
    }

    @GetMapping("/edit/{index}")
    public ModelAndView showEdit(@PathVariable int index){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("product", productService.getAll().get(index));
        modelAndView.addObject("categories", categoryService.getAll());
        return modelAndView;
    }

    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute Product product, @PathVariable int index,
                             @RequestParam int categoryIndex,@RequestParam MultipartFile file){
        String nameImg = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(), new File("/Users/johntoan98gmail.com/Desktop/C0322g1_QLSP/src/main/webapp/WEB-INF/img/" + nameImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        product.setImg("/img/" + nameImg);
        ModelAndView modelAndView = new ModelAndView("redirect:/products");
        product.setCategory(categoryService.getAll().get(categoryIndex));
        productService.edit(product,index);
        return modelAndView;
    }

    @GetMapping("/upload")
    public String upload(){
        return "up";
    }
}
