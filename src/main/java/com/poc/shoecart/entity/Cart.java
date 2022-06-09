package com.poc.shoecart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

	@Id
	@Column(name = "id")
	private long id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	//@OneToMany(mappedBy = "cart")
	//private List<Product> product;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id", referencedColumnName = "id")
	private List<Product> products;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(long id, User user, List<Product> products) {
		super();
		this.id = id;
		this.user = user;
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", products=" + products + "]";
	}

}