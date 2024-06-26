package com.Project.Project_springboot.service;

import com.Project.Project_springboot.model.Account;
import com.Project.Project_springboot.model.Order;
import com.Project.Project_springboot.model.OrderDetail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderSevice {
     List<Order> getAll();
     Order getById(Integer id);
    //don hnagf
    public List<OrderDetail> getId(String id);
//	public boolean delete_don_hang(int id);
    Boolean add(Order order);
    Boolean update(Order order);
    Boolean delete(Integer id);
    public boolean insertOrderDetail(Order order, List<OrderDetail> details );


    List<Order> searchOrder(String key);
    Page<Order> getAll(Integer pageNo);
    Page<Order>  searchOrder(String key, Integer pageNo);
}
