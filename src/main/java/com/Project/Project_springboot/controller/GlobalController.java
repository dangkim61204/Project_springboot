package com.Project.Project_springboot.controller;

import com.Project.Project_springboot.security.CustomerAccountDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalController {
        @ModelAttribute
        public void addUserToModel(Model model) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
                CustomerAccountDetail full_name = (CustomerAccountDetail) authentication.getPrincipal();
                model.addAttribute("full_name", full_name.getAccount().getFullName());
            }
        }

    @ModelAttribute
    public void addUserNameToModel(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && !(authentication.getPrincipal() instanceof String)) {
            CustomerAccountDetail email = (CustomerAccountDetail) authentication.getPrincipal();
            model.addAttribute("email", email.getAccount().getEmail());
        }
    }



}
