package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.modal.ReplayComment;

public interface ReplayCommentDao extends JpaRepository<ReplayComment, Long> {

}
