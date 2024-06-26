//package com.Project.Project_springboot.service;
//
//import com.Project.Project_springboot.model.CartItem;
//import com.Project.Project_springboot.repository.CartItemRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CartItemServiceImpl implements CartItemService {
//    private final CartItemRepository cartItemRepository;
//    @Override
//    public List<CartItem> getAll() {
//        return this.cartItemRepository.findAll();
//    }
//
//    @Override
//    public CartItem getById(Integer id) {
//        return this.cartItemRepository.findById(id).orElse(null);
//    }
//
//    @Override
//    public Boolean add(CartItem cartItem) {
//        try{
//            this.cartItemRepository.save(cartItem);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public Boolean update(CartItem cartItem) {
//        try{
//            this.cartItemRepository.save(cartItem);
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public Boolean delete(Integer id) {
//        try{
//            this.cartItemRepository.delete(getById(id));
//            return true;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//
//
//
//}
