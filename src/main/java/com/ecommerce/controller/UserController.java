package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.modal.User;
import com.ecommerce.service.UserService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/admin/findAllUsers")
	public List<User> findAllUsers() {
		return userService.findAllUsers();
	}

	@PutMapping("/editUser/{id}")
	User editUser(@RequestBody User user, @PathVariable long id) {
		return userService.editUser(user, id);
	}

	@GetMapping("/findUserById/{id}")
	User findUserById(@PathVariable long id) {
		return userService.findUserById(id);
	}

	@DeleteMapping("/deleteUser/{id}")
	void deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
	}
	
	@GetMapping("/findByUsername/{username}")
	User findByUsername(@PathVariable String username) {
		return userService.findByUsername(username);
	}
}
