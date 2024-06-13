package com.Project.Project_springboot.service;

import com.Project.Project_springboot.model.Account;

import java.util.List;

public interface AccountService {
    Account findByUserName(String userName);
    Account findByEmail(String email);
}
