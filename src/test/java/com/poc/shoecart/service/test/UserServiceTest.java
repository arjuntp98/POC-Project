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
	
	public List<User> myusers;
	
	@Test
	public void test_getallUsers() {
		List<User> myusers = new ArrayList<User>();
		myusers.add(new User(1,"Kiran","9878456512"));
		myusers.add(new User(2,"Balu","8978456521"));
		
		when(userRepository.findAll()).thenReturn(myusers);
		assertEquals(2,userServiceImpl.getallUsers().size());
	}
	
	@Test
	public void test_getUserById() {
		
	    User myusers = new User();
		myusers.setUserId(1);
		myusers.setName("Karan");
		myusers.setMobileNumber("9878784512");
		
		when(userRepository.findById(1L)).thenReturn(Optional.of(myusers));
		assertEquals(1L,userServiceImpl.getUserById(1L).getUserId());
	}

	@Test
	public void test_addOrUpdateUser() {
		
		User myusers = new User();
		myusers.setUserId(1);
		myusers.setName("Karan");
		myusers.setMobileNumber("9878784512");
		
		when(userRepository.save(myusers)).thenReturn(myusers);
		assertEquals(myusers,userServiceImpl.addOrUpdateUser(myusers));
	}	
	
	@Test
	public void test_deleteUser(){
		User myusers = new User();
		myusers.setUserId(1);
		myusers.setName("Karan");
		myusers.setMobileNumber("9878784512");
		
		userRepository.deleteById(1L);
		verify(userRepository,times(1)).deleteById(1L);
		
	}
	
	
}