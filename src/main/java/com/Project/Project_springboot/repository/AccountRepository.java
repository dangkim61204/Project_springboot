package com.Project.Project_springboot.repository;

import com.Project.Project_springboot.model.Account;
import com.Project.Project_springboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


public interface AccountRepository extends  JpaRepository<Account, String> {
    @Query("SELECT ac FROM Account ac WHERE ac.fullName LIKE %?1% ")
    List<Account> searchAccount(String key);


    Account findByUserName(String userName);
    Account findByEmail(String email);


}
