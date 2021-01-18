
package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.modal.Tag;

public interface TagDao extends JpaRepository<Tag, Long>{

}
