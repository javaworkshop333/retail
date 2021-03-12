package com.tutorial.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;
@WebServlet("/login") // url mapping
public class LoginServlet extends HttpServlet {

	// 12.12.12.12
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		String uid = req.getParameter("userid");
		String pwd = req.getParameter("password");
		
		try {
			if(uid.equals("john") && pwd.equals("jane"))
				res.sendRedirect("welcome.html");
			else
				res.sendRedirect("error.html");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		doGet(req,res);
		/*
		// 12.12.12.12
		String ip = req.getRemoteAddr();
		if (ip == "12.12.12.12") {
			res.getWriter().print("security threat detected... you are blocked");
			return;
		}

		String acctTo = req.getParameter("destinationAcct");
		String transferAmmount = req.getParameter("amount");

		HttpSession customerSession = req.getSession();
		customerSession.invalidate();

		boolean isloggedin = (boolean) customerSession.getAttribute("isloggedIn");
		if (isloggedin == true)
			System.out.println("transfer money");
		else
			res.sendRedirect("login.html"); // send session id - 123
*/
	}

}
