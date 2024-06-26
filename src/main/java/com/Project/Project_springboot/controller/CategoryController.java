package com.Project.Project_springboot.controller;

import com.Project.Project_springboot.model.Category;
import com.Project.Project_springboot.model.Product;
import com.Project.Project_springboot.repository.CategoryRepository;
import com.Project.Project_springboot.repository.ProductReposity;
import com.Project.Project_springboot.service.CategoryService;
import com.Project.Project_springboot.service.ProductService;
import com.Project.Project_springboot.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.model.IModel;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private StorageService storageService;

    @Autowired
    private ProductReposity productReposity;



    @RequestMapping("admin/category")
    public String index(Model model, @RequestParam(name="pageNo",defaultValue = "1") Integer pageNo){
        Page<Category> list =this.categoryService.getAll(pageNo);
        model.addAttribute("totalPage", list.getTotalPages());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("list", list);
        return "admin/category/index";
    }

    @RequestMapping("admin/addcategory")
    public String add(Model model ){
        Category category = new Category();
        model.addAttribute("category", category);
        category.setActive(true);

        return "admin/category/addcategory";
    }

    @PostMapping("admin/addcategory")
    public String save(@ModelAttribute("category") Category category, @RequestParam("file") MultipartFile file){
        this.storageService.store(file);
        String fileName = file.getOriginalFilename();
        category.setImage(fileName);
        if(this.categoryService.add(category)){
            return "redirect:/admin/category";
        }
         else{
            return "admin/category/addcategory";
        }

    }

    @RequestMapping("admin/editcategory/{id}")
    public String edit(Model model , @PathVariable("id") Integer id){
        Category category = this.categoryService.getById(id);
        model.addAttribute("category", category);
        return "admin/category/editcategory";
    }

    @PostMapping("admin/editcategory")
    public String update(@ModelAttribute("category") Category category, @RequestParam("file") MultipartFile file, @RequestParam("oldPicture") String oldPicture){
        String fileName = file.getOriginalFilename();
        if(fileName.equals("")){
            category.setImage(oldPicture);
        }else{

            category.setImage(fileName);
            this.storageService.store(file);
        }
        if(this.categoryService.update(category)){
            return "redirect:/admin/category";
        }else{
            return "admin/category/editcategory";
        }
    }

    @RequestMapping("admin/deletecategory/{id}")
    public String delete( @PathVariable("id") Integer id, Model model,@RequestParam(name="pageNo",defaultValue = "1") Integer pageNo){
        if(this.productReposity.categoryId(id).stream().findFirst().isPresent()){
             model.addAttribute("mes", "không thể xoá danh mục khi đã có sp thuộc danh mục này");
            Page<Category> list =this.categoryService.getAll(1);
            model.addAttribute("totalPage", list.getTotalPages());
            model.addAttribute("currentPage", 1);
            model.addAttribute("list", list);
            return "admin/category/index";
        }
        if(this.categoryService.delete(id)){
            return "redirect:/admin/category";
        }else{
            return "admin/category/index";
        }
    }




}
