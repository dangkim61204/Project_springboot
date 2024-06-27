package com.Project.Project_springboot.repository;

import com.Project.Project_springboot.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Iterator;
import java.util.List;

public interface ProductReposity extends JpaRepository<Product, Integer> {
  //search namw admin product
    @Query("SELECT p FROM Product p WHERE p.productName LIKE %?1% ")
    List<Product> searchProduct(String key);

    //timf kieems nhieu danh muc  theo danh muc trang shop
    @Query("SELECT p FROM Product p WHERE p.category.categoryId In :ids")
    List<Product> findByIdIn(List<Integer> ids);

    //timf kieems 1 danh muc  theo danh muc trang shop
    @Query("SELECT p FROM Product p WHERE p.category.categoryId = :id")
    List<Product> findByCategoryId(Integer id);


    @Query("SELECT p FROM Product p WHERE p.category.categoryId  = :id ")
    List<Product> categoryId(Integer id);


    Page<Product> findAll(Pageable pageable);

    //tìm khoảng giá sp
    @Query("SELECT p FROM Product p WHERE p.price >= :priceFrom")
    List<Product> searchPriceShopfrom(double priceFrom);
    @Query("SELECT p FROM Product p WHERE  p.price <= :priceTo")
    List<Product> searchPriceShopto( double priceTo);

    @Query("SELECT p FROM Product p WHERE p.price >= :priceFrom AND p.price <= :priceTo")
    List<Product> searchPriceShop(double priceFrom, double priceTo);
}
