package com.mphasis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.dao.UserDao;
import com.mphasis.exception.BusinessException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		RequestDispatcher dispatcher = null;

		if (!LoginBo.validateUserName(username) || !LoginBo.validatePassword(password)) {

			System.out.println("Invalid Credentails");
//			dispatcher = request.getRequestDispatcher("login.html");
//			dispatcher.forward(request, response);
		}

//		dispatcher = request.getRequestDispatcher("welcome.html");
//		dispatcher.forward(request, response); 
		System.out.println("verified");

		userDao = new UserDao();
		try {
			userDao.verifyUserCredentails(username, password);  
			System.out.println("credentials verified from database");
		} catch (BusinessException e) { 
			System.out.println(e.getMessage());
		}

	}

}
