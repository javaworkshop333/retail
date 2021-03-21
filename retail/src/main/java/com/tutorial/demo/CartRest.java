package com.tutorial.demo;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.beans.CartDetails;
 

@RestController
public class CartRest {
	@Autowired
	CartDetails cd;
	//http://localhost/add2Cart?product=iphone
	@RequestMapping(value = "/add2Cart", method = RequestMethod.GET)
	public String add2Cart(@RequestParam("product") String product) {
		String allItemName=cd.addItems(product);
		return allItemName;
	}
}