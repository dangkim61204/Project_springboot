package com.Project.Project_springboot.repository;

import com.Project.Project_springboot.model.Account;
import com.Project.Project_springboot.model.Order;

import com.Project.Project_springboot.model.OrderDetail;
import com.Project.Project_springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query("SELECT o FROM OrderDetail o  WHERE o.order.orderId = :id")
    public List<OrderDetail> getId(String id);

    @Query("SELECT ac FROM Account ac WHERE ac.fullName LIKE %?1% ")
    List<Order> searchOrder(String key);

    @Query("SELECT od FROM OrderDetail od WHERE od.order.orderId  = :id ")
    List<OrderDetail> OrderId(Integer id);

//    @Query("insert INTO Order (order_id, customer_id, order_date, total_amount) VALUES (?, ?, ?, ?)")
//    public boolean insertOrderDetail(Order order, List<OrderDetail> details );
}
