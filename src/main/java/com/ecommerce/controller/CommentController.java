package com.ecommerce.controller;

import com.ecommerce.modal.Comment;
import com.ecommerce.service.CommentService;

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

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CommentController {
 
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/addCommentToProduct/{idProduct}")
	Comment addCommentToProduct(@RequestBody Comment comment, @PathVariable long idProduct) {
		return commentService.addCommentToProduct(comment, idProduct);
	}
	@PutMapping("/editComment/{id}")
	Comment editComment(@RequestBody Comment comment, @PathVariable long id) {
		return commentService.editComment(comment, id);
	}
	@GetMapping("/findCommentById/{id}")
	Comment findCommentById(@PathVariable long id) {
		return commentService.findCommentById(id);
	}
	@DeleteMapping("/deleteComment/{id}")
	void deleteComment(@PathVariable long id) {
		commentService.deleteComment(id);
	}
	@GetMapping("/findCommentsForProduct/{idProduct}")
	List<Comment> findCommentsForProduct(@PathVariable long idProduct) {
		return commentService.findCommentsForProduct(idProduct);
	}
	@GetMapping("/findAllComments")
	List<Comment> findAllComments() {
		return commentService.findAllComments();
	}
}
