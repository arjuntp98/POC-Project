package com.poc.shoecart.service;

import com.poc.shoecart.entity.Cart;

public interface CartService {

	public Cart getCartByUserIdAndProductId(long userId,long productId);

	public Cart addToCart(long userId, long productId);

}
