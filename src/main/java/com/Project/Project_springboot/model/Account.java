package com.Project.Project_springboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="Accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Account {
    @Id
    @Column(name = "AccountId")
    private String accountId;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "Password")
    private String password;
    @Column(name = "FullName")
    private String fullName;
    @Column(name = "Picture")
    private String picture;
    @Column(name = "Email")
    private String email;
    @Column(name = "Gender")
    private boolean gender;
    @Column(name = "Birthday")
    private Date birthday;
    @Column(name = "Address")
    private String address;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Active")
    private boolean active;
    @Column(name = "Createdate")
    private Date createDate;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Set<Account_Role> accountRoles;



}