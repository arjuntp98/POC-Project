package com.poc.shoecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.shoecart.entity.Product;
import com.poc.shoecart.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/allProducts")
	public ResponseEntity<List<Product>> getAllProducts() {

		List<Product> product = null;

		try {
			product = productService.getAllProducts();
		} catch (Exception ex) {
			ex.getMessage();
		}

		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}

	@PostMapping("/addOrUpdate")
	public ResponseEntity<Product> addOrUpdate(@RequestBody Product product) {

		Product products = null;

		try {
			products = productService.addOrUpdateProduct(product);
		} catch (Exception ex) {
			ex.getMessage();
		}

		return new ResponseEntity<Product>(products, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") long productId) {

		Product product = null;

		try {
			product = productService.deleteProduct(productId);
		} catch (Exception ex) {
			ex.getMessage();
		}

		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

}
