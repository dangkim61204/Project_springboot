package com.Project.Project_springboot.repository;

import com.Project.Project_springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductReposity extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.productName LIKE %?1% ")
    List<Product> searchProduct(String key);

    @Query("SELECT p FROM Product p WHERE p.category.categoryId In :ids")
    List<Product> findByIdIn(List<Integer> ids);

    @Query("SELECT p FROM Product p WHERE p.category.categoryId = :id")
    List<Product> findByCategoryId(Integer id);

//    @Query("SELECT p FROM Product p WHERE p.category.categoryId in :ids and p.price= :price")
//    List<Product> finByPrices(List<Integer> ids, String price);
//
//    @Query("SELECT p FROM Product p WHERE p.category.categoryId = :id and p.price= :price")
//    List<Product> finByPrice(Integer id, String price);

//    List<Product> findByPriceBetween(Double from, Double to);

    //sort name A-Z
//    @Query("SELECT p FROM Product p ORDER BY p.productName ASC")
//    List<Product> findAllSortedByName();
}
