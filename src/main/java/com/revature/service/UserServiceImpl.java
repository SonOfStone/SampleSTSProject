package com.revature.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

	@Override
	public boolean isValidUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		final String username = req.getParameter("usernameInput");
		final String password = req.getParameter("passwordInput");
		
		final Logger LOGGY = LogManager.getLogger(RequestDispatcher.class);
		LOGGY.info("username = " + username +", password = " + password);
		
		if(username != null && !username.equals("") && password!=null && !password.equals("")) {
			UserRepository ur = new UserRepositoryImpl();

			
			if(ur.getUserByUsername(username) != null && password.contentEquals(ur.getUserByUsername(username).getPassword())) {
				LOGGY.info("dbusername = " + ur.getUserByUsername(username).getUsername());
				LOGGY.info("dbpassword = " + ur.getUserByUsername(username).getPassword());
				
				//user is authenticated
				//grant them a session
				
				HttpSession session = req.getSession();
				
				session.setAttribute("user", ur.getUserByUsername(username));
				
//				RequestDispatcher dispatchy = req.getRequestDispatcher("/Pages/nowPlaying.html");
//				dispatchy.forward(req, resp);
				
				resp.sendRedirect("/Reimbursement/Pages/main.html");
				
				return true;
				
			}
		}
		return false;
	}
	
	@Override
	public boolean logoutUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
			
			resp.sendRedirect("/Reimbursement/index.html");
			return true;
		}else {
			return false;
		}
	}
}
