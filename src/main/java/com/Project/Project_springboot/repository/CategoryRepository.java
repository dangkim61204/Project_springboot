package com.Project.Project_springboot.repository;

import com.Project.Project_springboot.model.Category;
import com.Project.Project_springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {


}
