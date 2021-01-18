package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.modal.OrderProduct;

public interface OrderProductDao extends JpaRepository<OrderProduct, Long> {

}
