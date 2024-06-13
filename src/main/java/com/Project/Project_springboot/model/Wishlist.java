//package com.Project.Project_springboot.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Entity
//@Table(name="Wishlists")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Wishlist {
//    @Id
//
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private Integer userId;
//    private Integer productId;
//
////    @ManyToOne(fetch = FetchType.EAGER)
////    @JoinColumn(name="userId", referencedColumnName = "id", insertable = false, updatable = false)
////    private User user;
////
////    @ManyToOne(fetch = FetchType.EAGER)
////    @JoinColumn(name="userId", referencedColumnName = "id", insertable = false, updatable = false)
////    private Product product;
//}
