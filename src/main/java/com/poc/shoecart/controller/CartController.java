package com.poc.shoecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.shoecart.entity.Cart;
import com.poc.shoecart.service.CartService;

//sample commit

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/getCartByUserId/{userId}")
	public ResponseEntity<Cart> getCartByUserId(@PathVariable("userId") long userId) {

		Cart cartItem = null;

		try {
			cartItem = cartService.getCartByUserId(userId);
			
		} catch (Exception ex) {
			ex.getMessage();
		}

		return new ResponseEntity<Cart>(cartItem, HttpStatus.OK);
	}
	
	/*
	@GetMapping("/getCartByUserIdAndProductId/{userId}/{productId}")
	public ResponseEntity<Cart> getCartByUserId(@PathVariable("userId") long userId,
			@PathVariable("productId") long productId) {

		Cart cartItem = null;

		try {
			cartItem = cartService.getCartByUserIdAndProductId(userId, productId);
			
		} catch (Exception ex) {
			ex.getMessage();
		}

		return new ResponseEntity<Cart>(cartItem, HttpStatus.OK);
	}

	@PostMapping("/addToCart")
	public ResponseEntity<Cart> addItemToCart(@RequestBody Cart cart) {
		Cart cartItem = null;

		try {
			cartItem = cartService.addToCart(cart.getUser().getUserId(), cart.getProduct().getProductId());
			
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Cart>(cartItem, HttpStatus.OK);

	}
*/
}
