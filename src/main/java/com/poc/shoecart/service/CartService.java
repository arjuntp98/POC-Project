package com.poc.shoecart.service;

import com.poc.shoecart.entity.Cart;
//sample commit
public interface CartService {

	public Cart getCartByUserId(long userId);
	
	//public Cart getCartByUserIdAndProductId(long userId, long productId);

	//public Cart addToCart(long userId, long productId);

}
