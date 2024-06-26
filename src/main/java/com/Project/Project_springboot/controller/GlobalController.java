package com.Project.Project_springboot.controller;

import com.Project.Project_springboot.model.CartItem;
import com.Project.Project_springboot.security.CustomerAccountDetail;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalController {
    //hển thị xin chào name ở trang admin
        @ModelAttribute
        public void addUserToModel(Model model) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
                CustomerAccountDetail full_name = (CustomerAccountDetail) authentication.getPrincipal();
                model.addAttribute("full_name", full_name.getAccount().getFullName());
            }
        }
//hển thị xin chào name ở trang người dùng
    @ModelAttribute
    public void addUserNameToModel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
            CustomerAccountDetail email = (CustomerAccountDetail) authentication.getPrincipal();
            model.addAttribute("email", email.getAccount().getEmail());
        }
    }

    // hiển thị số lượng(countItem) sp ở cart
    @ModelAttribute
    public void addCountItem(Model model, HttpServletRequest req) {
        List<CartItem> carts = new ArrayList<>();
        HttpSession session = req.getSession();
        if (session.getAttribute("cart") != null) {
            carts = (List<CartItem>) session.getAttribute("cart");
        }
        var itemCount = String.valueOf(carts.size());
        model.addAttribute("itemCount", itemCount);


    }



}
