package com.Project.Project_springboot.repository;

import com.Project.Project_springboot.model.Order;
import com.Project.Project_springboot.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {

}
