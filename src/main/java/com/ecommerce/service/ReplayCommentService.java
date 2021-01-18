package com.ecommerce.service;

import java.util.List;

import com.ecommerce.modal.ReplayComment;

public interface ReplayCommentService {
	
	ReplayComment addReplayComment(ReplayComment replayComment, long idComment);
	
	ReplayComment editReplayComment(ReplayComment replayComment, long id);
	
	void deleteReplayComment(long id);
	
	List<ReplayComment> findReplayCommentsForComment(long idComment);

}
