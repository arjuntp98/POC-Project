package com.poc.shoecart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poc.shoecart.entity.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {

	@Query(value = "select * from cart where user_id = :userId and product_id = :productId", nativeQuery = true)
	public Cart getCartByUserIdAndProductId(@Param("userId") long userId, @Param("productId") long productId);

}
