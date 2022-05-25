package com.poc.shoecart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.shoecart.entity.Cart;
import com.poc.shoecart.entity.Product;
import com.poc.shoecart.entity.User;
import com.poc.shoecart.repository.CartRepository;
import com.poc.shoecart.repository.ProductRepository;
import com.poc.shoecart.repository.UserRepository;
import com.poc.shoecart.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Cart getCartByUserIdAndProductId(long userId, long productId) {
		return cartRepository.getCartByUserIdAndProductId(userId, productId);
	}

	@Override
	public Cart addToCart(long userId, long productId) {

		Optional<User> usersOptnl = userRepository.findById(userId);

		User user = usersOptnl.get();

		Optional<Product> productOptnl = productRepository.findById(productId);

		Product product = productOptnl.get();

		Cart cart = new Cart();
		cart.setProduct(product);
		cart.setUser(user);

		return cartRepository.save(cart);
	}

}
