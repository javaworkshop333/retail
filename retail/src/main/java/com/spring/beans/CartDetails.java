package com.spring.beans;

import java.util.ArrayList;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class CartDetails {
	public ArrayList<String> cartItems=new ArrayList<String> ();
	public String addItems(String product) {
		cartItems.add(product);
		System.out.println(cartItems);
		return cartItems.toString();
	}
}
