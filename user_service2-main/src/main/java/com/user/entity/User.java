package com.user.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userInfo")
public class User {

	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Product> products;
//	List<Contact> contacts = new ArrayList<Contact>();

	
	
	public String getName() {
		return name;
	}

	public List<Product> getProducts() {
		return products;
	}

	 public void setProducts(List<Product> products) {
	        this.products = products;
	        for (Product product : products) {
	            product.setUser(this);  // Set the user in each product
	        }
	    }

	public User() {
		
		
	}
	public User(Integer userId, String name, String phone) {
		super();
		this.userId = userId;
		this.name = name;
		this.phone = phone;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
