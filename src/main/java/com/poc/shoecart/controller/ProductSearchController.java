package com.poc.shoecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.shoecart.entity.Product;
import com.poc.shoecart.service.ProductService;

@RestController
@RequestMapping("/searchProducts")
public class ProductSearchController {

	@Autowired
	private ProductService productService;

	@GetMapping("/byId/{id}")
	public ResponseEntity<Product> getProductsById(@PathVariable("id") long productId) {

		Product products = null;

		try {
			products = productService.getProductById(productId);
		} catch (Exception ex) {
			ex.getMessage();
		}

		return new ResponseEntity<Product>(products, HttpStatus.OK);
	}

	@GetMapping("/byPrice/{price}")
	public ResponseEntity<List<Product>> getAllProductsByPrice(@PathVariable("price") float price) {

		List<Product> products = null;

		try {
			products = productService.getProductsByPrice(price);
		} catch (Exception ex) {
			ex.getMessage();
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/byBrand/{brand}")
	public ResponseEntity<List<Product>> getAllProductsByBrand(@PathVariable("brand") String brand) {

		List<Product> products = null;

		try {
			products = productService.getProductsByBrand(brand);
		} catch (Exception ex) {
			ex.getMessage();
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}
}
