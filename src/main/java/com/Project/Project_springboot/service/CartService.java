//package com.Project.Project_springboot.service;
//
//import com.Project.Project_springboot.model.CartItem;
//import com.Project.Project_springboot.model.Product;
//import com.Project.Project_springboot.repository.CartItemRepository;
//import com.Project.Project_springboot.repository.ProductReposity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CartService {
//    @Autowired
//    private CartItemRepository cartItemRepository;
//    @Autowired
//    private ProductReposity  productReposity;
//
//    public  void addToCart(Integer productId, int quantity) {
//        Product product = productReposity.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
//        CartItem cartItem = new CartItem();
//        cartItem.setProduct(product);
//        cartItem.setQuantity(quantity);
//        cartItemRepository.save(cartItem);
//    }
//}
