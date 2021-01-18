package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.modal.Order;

public interface OrderDao extends JpaRepository<Order, Long> {

}
