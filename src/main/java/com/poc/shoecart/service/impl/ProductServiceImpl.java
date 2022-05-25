package com.poc.shoecart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.shoecart.entity.Product;
import com.poc.shoecart.repository.ProductRepository;
import com.poc.shoecart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product getProductById(long productId) {
		return productRepository.findById(productId).orElse(null);
	}

	@Override
	public Product addOrUpdateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product deleteProduct(long productId) throws Exception {
		
		Product deletedProduct = null;
		
			try {
				deletedProduct = productRepository.findById(productId).orElse(null);
				if (deletedProduct == null) {
					throw new Exception("product not available");
				} else {
					productRepository.deleteById(productId);
				}
			} catch (Exception ex) {
				throw ex;
			}
		
		return deletedProduct;
	}

	@Override
	public List<Product> getProductsByPrice(float price) {

		return productRepository.getProductByPrice(price);
	}

	@Override
	public List<Product> getProductsByBrand(String brand) {

		return productRepository.getProductsByBrand(brand);
	}

}
