package com.tutorial.demo;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse rsp)  {
		try {
			req.getSession().invalidate();	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
