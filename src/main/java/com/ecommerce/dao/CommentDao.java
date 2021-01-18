package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.modal.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {

}
