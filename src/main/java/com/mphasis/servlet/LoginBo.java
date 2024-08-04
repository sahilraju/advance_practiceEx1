package com.mphasis.servlet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginBo {

	public static boolean validateUserName(String userName) {

		Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@gmail\\.com$");
		Matcher match = pattern.matcher(userName);

		if (match.matches())
			return true;
		return false;

	}

	public static boolean validatePassword(String userName) {

		Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d).{10,20}$"); 
		Matcher match = pattern.matcher(userName);

		if (match.matches()) 
			return true;
		return false;

	}

	public static void main(String[] args) {

		System.out.println(validateUserName("sahilraju2001@gmail.com"));
		System.out.println(validatePassword("Nalifenaestem#aug6"));  

	}

}
