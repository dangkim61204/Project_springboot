package com.Project.Project_springboot.repository;

import com.Project.Project_springboot.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


public interface AccountRepository extends  JpaRepository<Account, String> {

    Account findByUserName(String userName);
    Account findByEmail(String email);


}
