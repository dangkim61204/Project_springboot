//package com.Project.Project_springboot.service;
//
//
//import com.Project.Project_springboot.model.OrderDetail;
//import com.Project.Project_springboot.repository.OrderDetailRepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class OrderDetailServiceImpl implements OrderDetailService{
//    @Autowired
//    private OrderDetailRepository orderDetailRepository;
//
//    @Override
//    public List<OrderDetail> getAll() {
//        return this.orderDetailRepository.findAll();
//    }
//
//    @Override
//    public OrderDetail getById(Integer id) {
//        return this.orderDetailRepository.findById(id).get();
//    }
//
//    @Override
//    public Boolean add(OrderDetail orderDetail) {
//        this.orderDetailRepository.save(orderDetail);
//        return true;
//    }
//
//    @Override
//    public Boolean update(OrderDetail orderDetail) {
//        this.orderDetailRepository.save(orderDetail);
//        return true;
//    }
//
//    @Override
//    public Boolean delete(Integer id) {
//        this.orderDetailRepository.deleteById(id);
//        return true;
//    }
//
//}
