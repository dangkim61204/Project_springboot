//package com.Project.Project_springboot.service;
//
//import com.Project.Project_springboot.model.Product;
//import com.Project.Project_springboot.repository.ProductReposity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ShopServiceImpl implements ShopService {
//    @Autowired
//    private ProductReposity productReposity;
//
//    @Override
//    public Page<Product> getPageShop(int page, int size) {
////        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
////        Pageable pageable1 = PageRequest.of(page, size, Sort.by("name").descending());
//        return productReposity.findAll(PageRequest.of(page, size));
//    }
//}
