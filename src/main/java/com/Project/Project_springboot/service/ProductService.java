package com.Project.Project_springboot.service;


import com.Project.Project_springboot.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


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
//sort name A-Z
//    List<Product> findAllSortedByName();
//    List<Product> findProductByIdsAndprice(List<Integer> ids, String price);
//
//    List<Product> findProductByIdAndprice(Integer id, String price);

    Page<Product> findAll(int page, int size, Sort sort);

    Page<Product> findAll(int page, int size);
}
