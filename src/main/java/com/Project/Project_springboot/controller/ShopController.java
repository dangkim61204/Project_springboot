package com.Project.Project_springboot.controller;

import com.Project.Project_springboot.model.Product;
import com.Project.Project_springboot.repository.CategoryRepository;
import com.Project.Project_springboot.service.CategoryService;
import com.Project.Project_springboot.service.ProductService;
import com.Project.Project_springboot.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.runtime.SwitchBootstraps;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StorageService storageService;
    public static List<Product> products=new ArrayList<>();
    @Autowired
    private CategoryRepository categoryRepository;

    //lọc sp theo danh mục
    @PostMapping("/filterCate")
    public String listProducts(@RequestParam(required = false) Integer categoryId, Model model, @RequestParam("cate") String cate, @RequestParam("price") String price ) {
        System.out.println(cate+"2222435");
        System.out.println(price+"11111222435");
        model.addAttribute("categories", categoryService.getAll());

        List<Integer> ids = new ArrayList<>() ;
        if(cate != null){
            if(cate.indexOf(',') > 0) {
                String[] dataSplit = cate.split(",");
                System.out.println(dataSplit);
                for (int i = 0; i < dataSplit.length; i++) {
                    ids.add(Integer.valueOf(dataSplit[i]));
                }
//                if(price != null){
//                    products = this.productService.findProductByIdsAndprice(ids,price);
//                }else{
//                    products = this.productService.findProductByIds(ids);
//                }
                products = this.productService.findProductByIds(ids);
            } else {
//                if(price != null){
////                    products = this.productService.findProductByIdAndprice(Integer.valueOf(cate),price);
//                }else {
//                    products = this.productService.findProductById(Integer.valueOf(cate));
//                }
                products = this.productService.findProductById(Integer.valueOf(cate));
            }

        } else {
            products = this.productService.getAll();
        }


        System.out.println(products.size()+"999999");
//        List<Category> categories = categoryRepository.findAll();
//        model.addAttribute("categories", categories);
//
//        List<Product> products;
//        if (categoryId != null) {
//            products = productService.getProductsByCategory(categoryId);
//        } else {
//            products = productService.getAll();
//        }
        model.addAttribute("products", products);
        return "/user/shop";
    }

    // sort name A-Z
    @GetMapping("/sort")
    public String sort(Model model,
//                       @RequestParam(defaultValue = "0") int page,
//                       @RequestParam(defaultValue = "12") int size,
                       @RequestParam(defaultValue = "default",required = false) String sort) {
        Sort sort1 = Sort.unsorted();
        switch (sort) {
            case "name_asc":
                sort1 = Sort.by("product_name").ascending();//a-z
                break;
            case "name_desc":
                sort1 = Sort.by("product_name").descending();//z-A
                break;
        }

        return "/user/shop";
    }

}
