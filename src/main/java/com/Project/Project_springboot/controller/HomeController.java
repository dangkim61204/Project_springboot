package com.Project.Project_springboot.controller;

import com.Project.Project_springboot.model.Account;
import com.Project.Project_springboot.model.Product;
import com.Project.Project_springboot.service.CategoryService;
import com.Project.Project_springboot.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;


    @RequestMapping({"/", "/home"})
    public String home(Model model){
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("products", productService.getAll());
        return "/user/home";
    }

    @RequestMapping("/about")
    public String about(){

        return "/user/about";
    }

    @RequestMapping("/page")
    public String page(){

        return "/user/page";
    }

    @RequestMapping("/product_detail/{id}")
    public String product_detail(@PathVariable Integer id, Model model){
        Product product = this.productService.getById(id);
        model.addAttribute("product", product);

        return "/user/product_detail";
    }

    @RequestMapping("/shop")
    public String shop(Model model){
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("products", productService.getAll());

        return "/user/shop";
    }

    @RequestMapping("/blog")
    public String blog(){

        return "/user/blog";
    }

    @RequestMapping("/faqs")
    public String faq(){

        return "/user/FAQs";
    }

    @RequestMapping("/contact")
    public String contact(){

        return "/user/contact";
    }

    @RequestMapping("/cart")
    public String cart(){
        return "/user/cart";
    }

    @RequestMapping("/checkout")
    public String checkout(){

        return "/user/checkout";
    }






}
