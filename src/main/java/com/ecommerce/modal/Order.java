package com.ecommerce.modal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;

@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="orderProducts")
public class Order {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @JsonFormat(pattern="dd/MM/yyyy")
	 private LocalDate dateCreated;
		
	 private String status;
	 
	 @OneToMany(mappedBy="pk.order")
	 private List<OrderProduct> orderProducts = new ArrayList<OrderProduct>();

	public Order() {
		super();
	}

	public Order(LocalDate dateCreated, String status, List<OrderProduct> orderProducts) {
		super();
		this.dateCreated = dateCreated;
		this.status = status;
		this.orderProducts = orderProducts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	} 

}
