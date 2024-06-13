package com.Project.Project_springboot.repository;

import com.Project.Project_springboot.model.Account_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Account_RoleRepository extends JpaRepository<Account_Role, Integer> {
}
