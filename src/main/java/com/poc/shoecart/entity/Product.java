package com.poc.shoecart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long productId;

	@Column(name = "brand")
	private String brand;

	@Column(name = "color")
	private String color;

	@Column(name = "size")
	private int size;

	@Column(name = "category")
	private String category;

	@Column(name = "price")
	private float price;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(long productId, String brand, String color, int size, String category, float price) {
		super();
		this.productId = productId;
		this.brand = brand;
		this.color = color;
		this.size = size;
		this.category = category;
		this.price = price;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", brand=" + brand + ", color=" + color + ", size=" + size
				+ ", category=" + category + ", price=" + price + "]";
	}

}
