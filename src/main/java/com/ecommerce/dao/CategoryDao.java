package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.modal.Category;

public interface CategoryDao extends JpaRepository<Category, Long>  {

}
