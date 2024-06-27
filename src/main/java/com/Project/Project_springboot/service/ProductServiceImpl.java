package com.Project.Project_springboot.service;

import com.Project.Project_springboot.model.Product;
import com.Project.Project_springboot.repository.ProductReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductReposity productReposity;
    @Override
    public List<Product> getAll() {
        return this.productReposity.findAll();
    }

    @Override
    public Product getById(Integer id) {
        return this.productReposity.findById(id).get();
    }

    @Override
    public Boolean add(Product product) {
        try{
            this.productReposity.save(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean update(Product product) {
        try{
            this.productReposity.save(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Integer id) {
        try{
            this.productReposity.delete(getById(id));
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> searchProduct(String key) {
        return this.productReposity.searchProduct(key);
    }

    @Override
    public Page<Product> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo-1,5);
        return this.productReposity.findAll(pageable);
    }

    @Override
    public Page<Product> searchProduct(String key, Integer pageNo) {
        List list = this.searchProduct(key);

        Pageable pageable = PageRequest.of(pageNo-1,5);

        Integer start = (int) pageable.getOffset();

        Integer end =(int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size():pageable.getOffset() + pageable.getPageSize());

        list = list.subList(start, end);

        return new PageImpl<Product>(list, pageable, this.searchProduct(key).size());
    }

    @Override
    public List<Product> findProductByIds(List<Integer> ids) {
        return this.productReposity.findByIdIn(ids);
    }

    @Override
    public List<Product> findProductById(Integer id) {
        return this.productReposity.findByCategoryId(id);
    }

    @Override
    public List<Product> searchPriceShopfrom(double priceFrom) {
        return this.productReposity.searchPriceShopfrom(priceFrom);
    }

    @Override
    public List<Product> searchPriceShopto(double priceTo) {
        return productReposity.searchPriceShopto(priceTo);
    }

    @Override
    public List<Product> searchPriceShop(double priceFrom, double priceTo) {
        return productReposity.searchPriceShop(priceFrom, priceTo);
    }

    @Override
    public Page<Product> searchPriceShopfrom(double priceFrom, Integer pageNo) {
        List list = this.searchPriceShopfrom(priceFrom);

        Pageable pageable = PageRequest.of(pageNo-1,5);

        Integer start = (int) pageable.getOffset();

        Integer end =(int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size():pageable.getOffset() + pageable.getPageSize());

        list = list.subList(start, end);

        return new PageImpl<Product>(list, pageable, this.searchPriceShopfrom(priceFrom).size());
    }

    @Override
    public Page<Product> searchPriceShopto(double priceTo, Integer pageNo) {
        List list = this.searchPriceShopto(priceTo);

        Pageable pageable = PageRequest.of(pageNo-1,5);

        Integer start = (int) pageable.getOffset();

        Integer end =(int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size():pageable.getOffset() + pageable.getPageSize());

        list = list.subList(start, end);

        return new PageImpl<Product>(list, pageable, this.searchPriceShopto(priceTo).size());
    }

    @Override
    public Page<Product> searchPriceShop(double priceFrom, double priceTo, Integer pageNo) {

        List list = this.searchPriceShop(priceFrom, priceTo);

        Pageable pageable = PageRequest.of(pageNo-1,5);

        Integer start = (int) pageable.getOffset();

        Integer end =(int) ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size():pageable.getOffset() + pageable.getPageSize());

        list = list.subList(start, end);

        return new PageImpl<Product>(list, pageable, this.searchPriceShop(priceFrom, priceTo).size());
    }


    @Override
    public Page<Product> findAll(int page, int size, Sort sort) {
        Pageable pageable = PageRequest.of(page, size, sort);
        return productReposity.findAll(pageable);
    }

    @Override
     public Page<Product> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productReposity.findAll(pageable);
    }





}
