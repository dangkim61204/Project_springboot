//package com.Project.Project_springboot.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Entity
//@Table(name="OrderStatus")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class OrderStatus {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Column(name="OrderStatusName", columnDefinition = "Nvarchar(100)")
//    private String orderStatusName;
//
//    @OneToMany(mappedBy = "orderStatusId", cascade = CascadeType.ALL)
//    private List<Order> orders;
//}
