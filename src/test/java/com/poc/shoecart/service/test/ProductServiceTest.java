package com.poc.shoecart.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.shoecart.entity.Product;
import com.poc.shoecart.repository.ProductRepository;
import com.poc.shoecart.service.impl.ProductServiceImpl;

@SpringBootTest(classes = { ProductServiceTest.class })
public class ProductServiceTest {

	@Mock
	ProductRepository productRepository;

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Test
	public void test_getAllProducts() {

		List<Product> myProducts = new ArrayList<Product>();
		myProducts.add(new Product(1130, "Woodland", "Brown", 9, "Formal", 1900));
		myProducts.add(new Product(1131, "Nike", "Black", 10, "Sports", 1500));

		when(productRepository.findAll()).thenReturn(myProducts);
		assertEquals(2, productServiceImpl.getAllProducts().size());

	}

	@Test
	public void test_getProductById() {

		Product myProducts = new Product();
		myProducts.setProductId(1130);
		myProducts.setBrand("Woodland");
		myProducts.setColor("Brown");
		myProducts.setCategory("Formal");
		myProducts.setSize(9);
		myProducts.setPrice(1900);

		when(productRepository.findById(1130L)).thenReturn(Optional.of(myProducts));
		assertEquals(1130, productServiceImpl.getProductById(1130L).getProductId());

	}

	@Test
	public void test_addOrUpdateProduct() {

		Product myProducts = new Product();
		myProducts.setProductId(1130);
		myProducts.setBrand("Woodland");
		myProducts.setColor("Brown");
		myProducts.setCategory("Formal");
		myProducts.setSize(9);
		myProducts.setPrice(1900);

		when(productRepository.save(myProducts)).thenReturn(myProducts);
		assertEquals(myProducts, productServiceImpl.addOrUpdateProduct(myProducts));

	}

	@Test
	public void test_deleteProduct() {

		Product myProducts = new Product();
		myProducts.setProductId(1130);
		myProducts.setBrand("Woodland");
		myProducts.setColor("Brown");
		myProducts.setCategory("Formal");
		myProducts.setSize(9);
		myProducts.setPrice(1900);

		productRepository.deleteById(1130L);
		verify(productRepository, times(1)).deleteById(1130L);
	}

	@Test
	public void test_getProductsByPrice() {

		List<Product> myProducts = new ArrayList<Product>();

		myProducts.add(new Product(1130, "Woodland", "Brown", 9, "Formal", 1900));

		when(productRepository.getProductByPrice(1900)).thenReturn(myProducts);
		assertEquals(1, productServiceImpl.getProductsByPrice(1900).size());

	}

	@Test
	public void test_getProductsByBrand() {

		List<Product> myProducts = new ArrayList<Product>();

		myProducts.add(new Product(1131, "Nike", "Black", 10, "Sports", 1500));

		when(productRepository.getProductsByBrand("Nike")).thenReturn(myProducts);
		assertEquals(1, productServiceImpl.getProductsByBrand("Nike").size());

	}
}
