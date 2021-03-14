package com.tutorial.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;
@WebServlet("/login") // annotation - project configuration - url mapping
public class LoginServlet extends HttpServlet {
	// doGet & doPost REQUIRED to override
	
	// http://localhost/login?userid=john&password=jane
	// tomcat container
	// 1) identify servlet program for /login = LoginServlet 
	// 2) service method is called to identify doget or dopost
	// 3) tomcat container puts userid=john&password=jane in HttpServletRequest paremter 
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		
		// 1.2.3.4
		if(req.getRemoteAddr() == "1.2.3.4")
			return;
		
		String uid = req.getParameter("userid");
		String pwd = req.getParameter("password");
		System.out.println( req.getQueryString() );
		
		UsersTable ut=new UsersTable();
		Connection conn=DatabaseConnection.getDBConnection();
		try{
			boolean loginResult=ut.validateLogin(uid, pwd, conn);
			if(loginResult == true)
			{
				res.getWriter().write(" login is successful "); // text format response
				/*
				req.getSession().setAttribute("login", "success");
				res.sendRedirect("welcome.html");
				*/
			}
			else {
				byte[] b="login failed".getBytes();
				res.getOutputStream().write(b); // binary format response
				/*
				req.getSession().setAttribute("login", "failed");
				req.getRequestDispatcher("error.jsp").forward(req, res);
				*/
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		doGet(req,res);
	}

	public void init(ServletConfig config) {
		System.out.println("setting up servlet information");
	}
	
	public void destroy() {
		System.out.println("cleaning servlet information");
	}
}
