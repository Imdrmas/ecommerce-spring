package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.modal.ReplayComment;
import com.ecommerce.service.ReplayCommentService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ReplayCommentController {
	
	@Autowired
	private ReplayCommentService replayCommentService;
	
	@PostMapping("/addReplayComment/{idComment}")
	ReplayComment addReplayComment(@RequestBody ReplayComment replayComment, @PathVariable long idComment) {
		return replayCommentService.addReplayComment(replayComment, idComment);
	}
	
	@PutMapping("/editReplayComment/{id}")
	ReplayComment editReplayComment(@RequestBody ReplayComment replayComment, @PathVariable long id) {
		return replayCommentService.editReplayComment(replayComment, id);
	}
	@DeleteMapping("/deleteReplayComment/{id}")
	void deleteReplayComment(@PathVariable long id) {
		replayCommentService.deleteReplayComment(id);
	}
	
	@GetMapping("/findReplayCommentsForComment/{idComment}")
	List<ReplayComment> findReplayCommentsForComment(@PathVariable long idComment) {
		return replayCommentService.findReplayCommentsForComment(idComment);
	}
}
