package com.Project.Project_springboot.controller;

import com.Project.Project_springboot.model.Account;
import com.Project.Project_springboot.security.CustomerAccountDetail;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String index(){
        return "redirect:/admin/";
    }


    @RequestMapping("/")
        public String admin(HttpServletRequest request, Model model){

        return "/admin/index";
        }

}
