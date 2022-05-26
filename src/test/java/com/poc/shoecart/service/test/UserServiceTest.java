package com.poc.shoecart.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.shoecart.entity.User;
import com.poc.shoecart.repository.UserRepository;

import com.poc.shoecart.service.impl.UserServiceImpl;

@SpringBootTest(classes= {UserServiceTest.class})
public class UserServiceTest {

	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	public List<User> myUsers;
	
	@Test
	public void test_getallUsers() {
		List<User> myUsers = new ArrayList<User>();
		myUsers.add(new User(130,"Kiran","9878456512"));
		myUsers.add(new User(132,"Balu","8978456521"));
		
		when(userRepository.findAll()).thenReturn(myUsers);
		assertEquals(2,userServiceImpl.getallUsers().size());
	}
	
	@Test
	public void test_getUserById() {
		
	    User myUsers = new User();
	    myUsers.setUserId(130);
	    myUsers.setName("Karan");
	    myUsers.setMobileNumber("9878784512");
		
		when(userRepository.findById(130L)).thenReturn(Optional.of(myUsers));
		assertEquals(130L,userServiceImpl.getUserById(130L).getUserId());
	}

	@Test
	public void test_addOrUpdateUser() {
		
		User myUsers = new User();
		myUsers.setUserId(130);
		myUsers.setName("Karan");
		myUsers.setMobileNumber("9878784512");
		
		when(userRepository.save(myUsers)).thenReturn(myUsers);
		assertEquals(myUsers,userServiceImpl.addOrUpdateUser(myUsers));
	}	
	
	@Test
	public void test_deleteUser(){
		User myUsers = new User();
		myUsers.setUserId(30);
		myUsers.setName("Karan");
		myUsers.setMobileNumber("9878784512");
		
		userRepository.deleteById(130L);
		verify(userRepository,times(1)).deleteById(130L);
		
	}
	
	
}