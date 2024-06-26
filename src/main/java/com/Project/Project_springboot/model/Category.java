package com.Project.Project_springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @Column(name="CategoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    @Column(name="CategoryName" ,columnDefinition="Nvarchar(100)")
    private String categoryName;
    @Column(name="Image" , columnDefinition="Nvarchar(255)")
    private String image;
    @Column(name="Active")
    private boolean active;

//    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
//    private List<Product> products;

}
