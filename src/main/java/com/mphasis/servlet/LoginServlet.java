package com.mphasis.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.dao.UserDao;
import com.mphasis.dto.User;
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

		try {

			if (LoginBo.validateUserName(username) == false || LoginBo.validatePassword(password) == false) 
				throw new BusinessException("Invalid Credentails"); 
			
		} catch (BusinessException e) {
			request.setAttribute("errorMessage", "Invalid Credentails");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			return; 
		}

		User user = new User();
		user.setUserName(username);
		user.setPassword(password);

		System.out.println("verified");

		userDao = new UserDao();
		try {
			userDao.verifyUserCredentails(user);
			System.out.println("credentials verified from database");
			response.sendRedirect("welcome.html");
		} catch (BusinessException e) {
			request.setAttribute("errorMessage", "Invalid Credentails");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			return; 
		}

	}

}
