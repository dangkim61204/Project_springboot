package com.Project.Project_springboot.service;

import com.Project.Project_springboot.model.Account;
import com.Project.Project_springboot.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountService {
    Account findByUserName(String userName);
    Account findByEmail(String email);
    List<Account> getAll();
    Account getById(String id);
    Boolean delete(String id);
    List<Account> searchAccount(String key);
    Page<Account> getAll(Integer pageNo);
    Page<Account>  searchAccount(String key, Integer pageNo);
}
