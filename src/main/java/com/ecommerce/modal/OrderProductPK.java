package com.ecommerce.modal;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "order")
public class OrderProductPK implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(optional=false, fetch = FetchType.LAZY)
	@JoinColumn(name="orderId")
	private Order order;
	
	@ManyToOne(optional=false, fetch = FetchType.LAZY)
	@JoinColumn(name="productId")
	private Product product;

	public OrderProductPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((order.getId() == null)
				? 0
				: order
				.getId()
				.hashCode());
		result = prime * result + ((product.getId() == null)
				? 0
				: product
				.getId()
				.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OrderProductPK other = (OrderProductPK) obj;
		if (order == null) {
			if (other.order != null) {
				return false;
			}
		}else if (!order.equals(other.order)) {
			return false;
		}
		if (product == null) {
			if (other.product != null) {
				return false;
			}
		}else if (!product.equals(other.product)) {
			return false;
		}
		return true;
	}
	
}
