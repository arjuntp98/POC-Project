package com.poc.shoecart.service;

import java.util.List;

import com.poc.shoecart.entity.User;

public interface UserService {

		public List<User> getallUsers();
		
		public User getUserById(long userId);

		public User addOrUpdateUser(User user);
		
		public User deleteUser(long userId) throws Exception;
}
