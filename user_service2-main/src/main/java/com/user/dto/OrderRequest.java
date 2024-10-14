package com.user.dto;

import com.user.entity.User;

public class OrderRequest {

	private User user;

	public OrderRequest(User user) {
		super();
		this.user = user;
	}

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderRequest [user=" + user + "]";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
