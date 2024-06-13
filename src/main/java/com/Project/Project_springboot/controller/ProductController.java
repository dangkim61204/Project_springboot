package com.Project.Project_springboot.controller;

import com.Project.Project_springboot.model.Category;
import com.Project.Project_springboot.model.Product;
import com.Project.Project_springboot.repository.CategoryRepository;
import com.Project.Project_springboot.service.CategoryService;
import com.Project.Project_springboot.service.ProductService;
import com.Project.Project_springboot.service.StorageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StorageService storageService;
    public static List<Product> products=new ArrayList<>();
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("admin/product")
    public String index(Model model,@Param("key") String key, @RequestParam(name="pageNo",defaultValue = "1") Integer pageNo){
        Page<Product> list =this.productService.getAll(pageNo);
        if(key != null){
            list = this.productService.searchProduct(key, pageNo);
            model.addAttribute("key", key);
        }
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("list", list);
        return "admin/product/index";
    }

    @RequestMapping("admin/addproduct")
    public String add(Model model ){
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> listCate = this.categoryService.getAll();
        model.addAttribute("listCate", listCate);
        return "admin/product/addproduct";
    }

    @PostMapping("admin/addproduct")
    public String save(Model model ,@Valid @ModelAttribute("product") Product product, BindingResult result, @RequestParam("file") MultipartFile file) {



        if(result.hasErrors()) {

            this.storageService.store(file);
            String fileName = file.getOriginalFilename();
            product.setImage(fileName);
            if (this.productService.add(product)) {
                return "redirect:/admin/product";
            } else {
                model.addAttribute("listCate", categoryService.getAll());
                return "admin/product/addproduct";
            }

        }else

        {
            products.add(product);
            return "redirect:/";

        }
    }

    @RequestMapping("admin/editproduct/{id}")
    public String edit(@Valid  Model model , @PathVariable("id") Integer id){
        Product product = this.productService.getById(id);
        model.addAttribute("product", product);
        model.addAttribute("listCate", categoryService.getAll());
        return "admin/product/editproduct";
    }

    @PostMapping ("admin/editproduct")
    public String update(@ModelAttribute("product") Product product,@RequestParam("file") MultipartFile file, @RequestParam("oldPicture") String oldPicture){
        String fileName = file.getOriginalFilename();
        if(fileName.equals("")){
            product.setImage(oldPicture);
        }else{
            product.setImage(fileName);
            this.storageService.store(file);
        }

//        product.setPrice(Float.parseFloat(product.getPrice()));

        if(this.productService.update(product)){
            return "redirect:/admin/product";
        }else{
            return "admin/category/editproduct";
        }

    }

    @RequestMapping("admin/deleteproduct/{id}")
    public String delete( @PathVariable("id") Integer id){
        if(this.productService.delete(id)){
            return "redirect:/admin/product";
        }else{
            return "admin/product/index";
        }
    }




}


