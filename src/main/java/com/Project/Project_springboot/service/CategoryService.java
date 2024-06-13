package com.Project.Project_springboot.service;

import com.Project.Project_springboot.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Category getById(Integer id);
    Boolean add(Category category);
    Boolean update(Category category);
    Boolean delete(Integer id);
    Page<Category> getAll(Integer pageNo);


}
