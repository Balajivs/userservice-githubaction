package com.user.entity;

import java.util.HashSet;
import java.util.Set;

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
	@Column(name = "userId", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

	//@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	//@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	//@JoinColumn(name="userproduct_fk",referencedColumnName = "id")
	//private List<Product> products;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products = new HashSet<>();
	
	
	
	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "product_id") private Product product;
	 */

	
	


	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	 public Set<Product> getProducts() {
	        return products;
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
