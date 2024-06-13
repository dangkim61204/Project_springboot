package com.Project.Project_springboot.controller;

import com.Project.Project_springboot.model.CartItem;
import com.Project.Project_springboot.model.Product;
//import com.Project.Project_springboot.service.CartService;
import com.Project.Project_springboot.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
//    @Autowired
//    private CartService cartService;
    @Autowired
    private ProductService productService;




    @GetMapping("/cart-add/{id}")
    public String addToCart(@PathVariable("id") String id, HttpServletRequest req) {
        List<CartItem> carts = new ArrayList<>();
        HttpSession session = req.getSession();
        System.out.println(id +"4376532");

        Integer proid= Integer.parseInt(id);

        Product pr = productService.getById(proid);
        if (session.getAttribute("cart") == null) {
            CartItem cart = new CartItem(pr.getProductId(), pr.getProductName(), pr.getImage(), pr.getPrice(),1);
            carts.add(cart);
            session.setAttribute("cart", carts);
//            System.out.println(333333);
        } else {
            carts = (List<CartItem>) session.getAttribute("cart");
            boolean duplicate = false;
            for (int i = 0; i < carts.size(); i++) {
                CartItem bs = carts.get(i);
//                System.out.println(4444444);
                if (bs.getId() == proid) {
                    bs.setQuantity(bs.getQuantity() + 1);
                    duplicate = true;
                    break;

                }
            }
            if (duplicate)
                session.setAttribute("cart", carts);

            else {
                CartItem cart = new CartItem(pr.getProductId(), pr.getProductName(), pr.getImage(), pr.getPrice(),1);
                carts.add(cart);
                System.out.println(5555555);
            }
        }
        session.setAttribute("cart", carts);
        return String.valueOf(carts.size());

//        return "redirect:/product_detail/"+productId;
//        return "/user/product_detail";
    }

    @RequestMapping("/shopcart")
    public String viewCart(Model model, HttpServletRequest req) {
        model.addAttribute("page", "cart");
        List<CartItem> carts = new ArrayList<>();
        HttpSession session = req.getSession();
        if (session.getAttribute("cart") != null) {

            carts = (List<CartItem>) session.getAttribute("cart");
//            for (CartItem cart : carts) {
//                System.out.println(cart.getName()+"245241");
//            }
        }
        model.addAttribute("carts", carts);

        return "/user/cart";
    }

}
