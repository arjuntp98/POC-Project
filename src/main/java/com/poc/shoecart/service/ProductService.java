package com.poc.shoecart.service;

import java.util.List;

import com.poc.shoecart.entity.Product;

public interface ProductService {

	public List<Product> getAllProducts();

	public Product getProductById(long productId);

	public Product addOrUpdateProduct(Product product);

	public Product deleteProduct(long productId) throws Exception;

	// this method is calling from crud repository using @ query annotation
	
	public List<Product> getProductsByPrice(float price);

	public List<Product> getProductsByBrand(String brand);

}
