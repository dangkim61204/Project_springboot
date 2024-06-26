package com.Project.Project_springboot.repository;

import com.Project.Project_springboot.model.CartItem;
import com.Project.Project_springboot.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
//    List<CartItem> findByCart(Integer cartId);
//    CartItem findByProductIdAndCartId(Integer productId , Integer cartId);
//    public CartItem findByProductId(Integer productId , Integer orderId);
//
//    public CartItem findByAccountId(String accId);
//    public void deleteCart(String accId);
}
