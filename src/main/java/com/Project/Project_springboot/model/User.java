//package com.Project.Project_springboot.model;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Table(name="Users")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class User {
//    @Id
//
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer userId;
//    private String userName;
//    private String password;
////    @Column(name="Email", columnDefinition="Nvarchar(NTEXT)")
//    private String email;
//    @Column(name="FistName", columnDefinition="Nvarchar(NTEXT)")
//    private String fistName;
//    private String LastName;
//    private String address;
//    private String phone;
//    private boolean status;
//    @CreationTimestamp
//    @Temporal(TemporalType.DATE)
//    private Date date;
//    private String image;
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Wishlist> wishlists;
////    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
////    private Cart cart;
//
//
//
//
//
//
//
//}
