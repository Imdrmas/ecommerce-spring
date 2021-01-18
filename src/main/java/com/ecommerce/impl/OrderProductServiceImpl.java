package com.ecommerce.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.OrderProductDao;
import com.ecommerce.modal.OrderProduct;
import com.ecommerce.service.OrderProductService;

@Transactional
@Component
public class OrderProductServiceImpl implements OrderProductService {
	
	@Autowired
	private OrderProductDao orderProductDao;

	@Override
	public OrderProduct addOrderProduct(OrderProduct orderProduct) {
		  return this.orderProductDao.save(orderProduct);
	}

}
