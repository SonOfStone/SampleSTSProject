package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.revature.service.RequestServiceImpl;
import com.revature.service.UserServiceImpl;

public class RequestHelper {

	//this helper is a class that returns objects to our Request Dispatcher Servlet.
	
	public static Object processGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		final Logger LOGGY = LogManager.getLogger(RequestDispatcher.class);
		LOGGY.info("The request has been received by the Request Dispatcher. The Request URL is: " + req.getRequestURI());
		
		final String URI = req.getRequestURI().replace("/Reimbursement/api/", "");
		
		switch(URI) {
		case "logout":
			if(new UserServiceImpl().logoutUser(req, resp)) {
				LOGGY.info("Logout Successful");
				resp.setStatus(200);
				return "Logout Successful";
			}else {
				LOGGY.info("Logout Failed");
				resp.setStatus(200);
				//maybe move this to service layer
				resp.sendRedirect("../index.html");
				return "Logout Failed";
			}
		case "myforms":
			return new RequestServiceImpl().getPersonalRequests(req, resp);

		default:
			return "Resource Not Found";
		}
		
	}
	
	public static Object processPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		
		final Logger LOGGY = LogManager.getLogger(RequestDispatcher.class);
		LOGGY.info("The request has been received by the Request Dispatcher. The Request URL is: " + req.getRequestURI());

		
		final String URI = req.getRequestURI().replace("/Reimbursement/api/", "");
		
		LOGGY.info("The URI is now: " + URI);
		
		
		switch(URI) {
		case "login":
			if(new UserServiceImpl().isValidUser(req, resp)) {
				LOGGY.info("Login Successful");
				
				resp.setStatus(200);
				return "Login Successful";
			}else {
				LOGGY.info("Login Failed");

				resp.setStatus(200);
				//maybe move this to service layer
				resp.sendRedirect("../index.html");
				return "Login Failed";
			}
		case "insertrequest":

			new RequestServiceImpl().insertRequest(req, resp);
			resp.setStatus(200);
			resp.sendRedirect("/Reimbursement/Pages/main.html");
			return "Inserted";
		default:
			return "Endpoint Not Implemented";
		}
		
	}
}
