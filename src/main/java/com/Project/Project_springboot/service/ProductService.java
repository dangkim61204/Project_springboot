package com.Project.Project_springboot.service;


import com.Project.Project_springboot.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(Integer id);
    Boolean add(Product product);
    Boolean update(Product product);
    Boolean delete(Integer id);
    List<Product> searchProduct(String key);
    Page<Product> getAll(Integer pageNo);
    Page<Product>  searchProduct(String key, Integer pageNo);

    List<Product> findProductByIds(List<Integer> ids);

    List<Product> findProductById(Integer id);

    //tim khoang gia
//    List<Product> findByPriceBetween(Double fromPrice, Double toPrice);
    List<Product> searchPriceShopfrom(double priceFrom);
    List<Product> searchPriceShopto( double priceTo);
    List<Product> searchPriceShop(double priceFrom, double priceTo);
    Page<Product>  searchPriceShopfrom(double priceFrom, Integer pageNo);
    Page<Product>  searchPriceShopto(double priceTo, Integer pageNo);
    Page<Product>  searchPriceShop(double priceFrom, double priceTo, Integer pageNo);


    Page<Product> findAll(int page, int size, Sort sort);
    Page<Product> findAll(int page, int size);

    //sort
//    Page<Product>  searchPageShop(Sort sort, Integer pageNo);
}
