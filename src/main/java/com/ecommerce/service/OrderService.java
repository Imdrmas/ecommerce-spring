package com.ecommerce.service;

import com.ecommerce.modal.Order;

public interface OrderService {
	
	Iterable<Order> getAllOrders();

    Order createOrder(Order order);

    void updateOrder(Order order);
    
    void deleteOrder(long id);
}
