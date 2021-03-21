package com.strut;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.hibernate.LoginEntity;
import com.opensymphony.xwork2.ActionSupport;
import com.spring.beans.CartDetails;
import com.spring.beans.ProfileBean;


public class Add2Cart extends ActionSupport {

	public String product;

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	// business method
	@Autowired
	public CartDetails cart;

	public String execute() {
		String cartItems = cart.addItems(product);
		inputStream = new StringBufferInputStream(cartItems);
		return "success";
	}
}
