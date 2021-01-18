package com.ecommerce.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.OrderDao;
import com.ecommerce.modal.Order;
import com.ecommerce.service.OrderService;

@Transactional
@Component
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderDao.findAll();
    }

    @Override
    public Order createOrder(Order order) {
        order.setDateCreated(LocalDate.now());
        return this.orderDao.save(order);
    }

    @Override
    public void updateOrder(Order order) {
        this.orderDao.save(order);
    }

	@Override
	public void deleteOrder(long id) {
		orderDao.deleteById(id);
	}

}
