package com.tutorial.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart")
public class cart extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)  {
		String prod=req.getParameter("product");
		
		if(req.getSession().getAttribute("cart") == null)
			req.getSession().setAttribute("cart",new ArrayList<String>());
		
		((ArrayList<String>)req.getSession().getAttribute("cart")).add(prod);
		
		System.out.println("cart items : "+req.getSession().getAttribute("cart"));
		
	}
}
