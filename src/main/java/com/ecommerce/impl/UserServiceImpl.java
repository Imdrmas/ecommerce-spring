package com.ecommerce.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dao.UserDao;
import com.ecommerce.modal.User;
import com.ecommerce.service.UserService;

@Transactional
@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User addUser(User user) {
		List<User> users = userDao.findAll();
		if (users.size() == 0) {
			user.setAdmin(true);
		}
		
		for (User userExist : users) {
			if (user.getUsername().equals(userExist.getUsername())) {
				userExist.setUsername(userExist.getUsername());
				userExist.setPassword(userExist.getPassword());
				return userDao.save(userExist);
			}
		}
	
		return userDao.save(user);	
	}

	@Override
	public List<User> findAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User editUser(User user, long id) {
		User existUser = userDao.findById(id).orElse(null);
		existUser.setUsername(user.getUsername());
		existUser.setPassword(user.getPassword());
		existUser.setAdmin(user.isAdmin());
		existUser.setEmail(user.getEmail());
		existUser.setNameOnCard(user.getNameOnCard());
		existUser.setCardNumber(user.getCardNumber());
		existUser.setCvv(user.getCvv());
		existUser.setAddress(user.getAddress());
		return userDao.save(existUser);
	}

	@Override
	public User findUserById(long id) {
      return userDao.findById(id).orElse(null);
	}

	@Override
	public void deleteUser(long id) {
		userDao.deleteById(id);
	} 
	
	@Override
	 public User findByUsername(String username) {
		   Optional<User> users = userDao.findByUsername(username);
		    if (users.isPresent()) {
		     User user = users.get();
		   return user;
		  }
		   return null;
		 }


}
