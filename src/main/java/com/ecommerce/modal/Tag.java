package com.ecommerce.modal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "tags")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;

	@JsonBackReference(value = "product")
	@ManyToOne
	private Product product;
	
	@JsonProperty(access = Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_tags",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private List<Product> products;

	public Tag() {
		super();
	}

	public Tag(String name, Product product, List<Product> products) {
		super();
		this.name = name;
		this.product = product;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

    public void addProductToTag(Product product) {
    	if(getProducts()==null) {
    		this.products = new ArrayList<>();
    	}
        if (!getProducts().contains(product)) {
        	getProducts().add(product);
        }
    }
   
	
	
}
