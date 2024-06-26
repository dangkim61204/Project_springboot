package com.Project.Project_springboot.controller;

import com.Project.Project_springboot.model.CartItem;
import com.Project.Project_springboot.model.Order;
import com.Project.Project_springboot.model.OrderDetail;
import com.Project.Project_springboot.model.Product;
//import com.Project.Project_springboot.service.CartService;
import com.Project.Project_springboot.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
public class CartController {
//    @Autowired
//    private CartService cartService;
    @Autowired
    private ProductService productService;



/// add sp vào cart
    @GetMapping("/cart-add/{id}")
    public @ResponseBody String addToCart(@PathVariable("id") String id, HttpServletRequest req) {
        List<CartItem> carts = new ArrayList<>();
        HttpSession session = req.getSession();

        Integer proid= Integer.parseInt(id);

        Product pr = productService.getById(proid);

        if (session.getAttribute("cart") == null) {

            CartItem cart = new CartItem(pr.getProductId(), pr.getProductName(), pr.getImage(), pr.getPrice(),1);

            carts.add(cart);

            session.setAttribute("cart", carts);

            List<CartItem> data = (List<CartItem>) session.getAttribute("cart");
            for (CartItem cartItem : data) {
            }

        } else {
            carts = (List<CartItem>) session.getAttribute("cart");
            boolean duplicate = false;
            for (int i = 0; i < carts.size(); i++) {
                CartItem bs = carts.get(i);
                if (bs.getId() == proid) {
                    bs.setQuantity(bs.getQuantity() + 1);
                    duplicate = true;
                    break;

                }
            }
            if (duplicate) {
                session.setAttribute("cart", carts);
            }

            else {
                CartItem cart = new CartItem(pr.getProductId(), pr.getProductName(), pr.getImage(), pr.getPrice(),1);
                carts.add(cart);

            }
        }
        session.setAttribute("cart", carts);
        return String.valueOf(carts.size());
    }

// view cart
    @RequestMapping("/cart")
    public String viewCart(Model model, HttpServletRequest req) {
        model.addAttribute("page", "cart");
        List<CartItem> carts = new ArrayList<>();
        HttpSession session = req.getSession();
        if (session.getAttribute("cart") != null) {

            carts = (List<CartItem>) session.getAttribute("cart");
            for (CartItem cart : carts) {
                System.out.println(cart.getId() + " " + cart.getName() + " " + cart.getQuantity());

            }

        }

        double total = carts.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        // Đưa danh sách sản phẩm và tổng giá trị vào model

        model.addAttribute("total", total);
        model.addAttribute("carts", carts);

        return "/user/cart";
    }


    //update carrt
    @RequestMapping(value = "updateCart/{id}/{value}")
    public @ResponseBody String updateBasket(@PathVariable("id") Integer id, @PathVariable("value") Integer quantity,
                                             Model model, HttpServletRequest req) {
        List<CartItem> datacart = new ArrayList<>();
        HttpSession session = req.getSession();
        if (session.getAttribute("cart") != null) {
            datacart = (List<CartItem>) session.getAttribute("cart");
            for (int i = 0; i < datacart.size(); i++) {
                CartItem cs = datacart.get(i);
                if (cs.getId().equals(id)) {
                    cs.setQuantity(quantity);
                    break;

                }
            }

        }
        return "";
    }

    //GET: removeItem/{id} "xóa một sp trong giỏ hang"
    @RequestMapping(value = "removeItem/{id}")
    public @ResponseBody String removeItem(@PathVariable("id") String id, HttpServletRequest req) {
        List<CartItem> Removecarts = new ArrayList<>();
        HttpSession session = req.getSession();
        Integer proid= Integer.parseInt(id);
        boolean find = false;
        if (session.getAttribute("cart") != null) {
            int i;
            Removecarts = (List<CartItem>) session.getAttribute("cart");
            for (i = 0; i < Removecarts.size(); i++) {
                CartItem bs = Removecarts.get(i);
                if (bs.getId() == proid) {
                    find = true;
                    break;
                }
            }
            if (find) {
                Removecarts.remove(i);
            }
            session.setAttribute("cart", Removecarts);
        }

        return "";
    }



}
