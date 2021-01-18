package com.ecommerce.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.CommentDao;
import com.ecommerce.dao.ReplayCommentDao;
import com.ecommerce.modal.Comment;
import com.ecommerce.modal.ReplayComment;
import com.ecommerce.service.ReplayCommentService;

@Transactional
@Component
public class ReplayCommentServiceImpl implements ReplayCommentService {
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private ReplayCommentDao replayCommentDao;

	@Override
	public ReplayComment addReplayComment(ReplayComment replayComment, long idComment) {
		Comment comment = commentDao.findById(idComment).orElse(null);
		replayComment.setAddedAt(new Date());
		comment.addReplayCommentToComment(replayComment);
		return replayCommentDao.save(replayComment);
	}

	@Override
	public ReplayComment editReplayComment(ReplayComment replayComment, long id) {
		ReplayComment existReplayComment = replayCommentDao.findById(id).orElse(null);
		existReplayComment.setMessageReplay(replayComment.getMessageReplay());
		existReplayComment.setAddedAt(new Date());
		return replayCommentDao.save(existReplayComment);
	}

	@Override
	public void deleteReplayComment(long id) {
		replayCommentDao.deleteById(id);
	}

	@Override
	public List<ReplayComment> findReplayCommentsForComment(long idComment) {
		Comment comment = commentDao.findById(idComment).orElse(null);
		return comment.getReplayComments();
	}

}
