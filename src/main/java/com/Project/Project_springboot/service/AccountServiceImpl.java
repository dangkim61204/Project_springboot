package com.Project.Project_springboot.service;

import com.Project.Project_springboot.model.Account;
import com.Project.Project_springboot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
//
//    @Override
//    public Account findAll(String userName) {
//        return accountRepository.findByUserName(userName);
//    }


    @Override
    public Account findByUserName(String userName) {
        return accountRepository.findByUserName(userName);
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }
}
