package com.poc.shoecart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.poc.shoecart.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query(value = "select * from product where price < :price", nativeQuery = true)
	public List<Product> getProductByPrice(@Param("price") float price);

	@Query(value = "select * from product where brand = :brand", nativeQuery = true)
	public List<Product> getProductsByBrand(@Param("brand") String brand);

}
