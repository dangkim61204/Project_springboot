//package com.Project.Project_springboot.service;
//
//import com.Project.Project_springboot.model.OrderStatus;
//import com.Project.Project_springboot.repository.OrderDetailRepository;
//import com.Project.Project_springboot.repository.OrderStatusRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrderStatusServiceImpl implements OrderStatusService{
//    @Autowired
//    private OrderStatusRepository orderStatusRepository;
//
//
//    @Override
//    public List<OrderStatus> getAll() {
//        return this.orderStatusRepository.findAll();
//    }
//
//    @Override
//    public OrderStatus getById(Integer id) {
//        return this.orderStatusRepository.findById(id).get();
//    }
//
//    @Override
//    public Boolean add(OrderStatus orderStatus) {
//        this.orderStatusRepository.save(orderStatus);
//        return true;
//    }
//
//    @Override
//    public Boolean update(OrderStatus orderStatus) {
//        this.orderStatusRepository.save(orderStatus);
//        return true;
//    }
//
//    @Override
//    public Boolean delete(Integer id) {
//        this.orderStatusRepository.deleteById(id);
//        return true;
//    }
//}
