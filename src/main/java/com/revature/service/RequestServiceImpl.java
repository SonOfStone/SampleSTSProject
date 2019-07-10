package com.revature.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.revature.model.ReimburseReq;
import com.revature.model.User;
import com.revature.repository.RequestRepositoryImpl;
import com.revature.web.RequestDispatcher;

public class RequestServiceImpl implements RequestService{

	@Override
	public void insertRequest(HttpServletRequest req, HttpServletResponse resp) {
		//initialize logger
		final Logger LOGGY = LogManager.getLogger(RequestDispatcher.class);
		
		//date formatting
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	    Date date = new Date();

		//grab user info from session
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");
		
		LOGGY.info("The user attached to the session: " + user);
		
		//grab params from form
		final Integer requestId = null;
		final Integer userId = user.getUserId();
		final String eventName = req.getParameter("eventName");
		final String eventDate = req.getParameter("eventDate");
		final String eventTime = req.getParameter("eventTime");
		final String location = req.getParameter("location");
		final String description = req.getParameter("description");
		final Double cost = Double.parseDouble(req.getParameter("cost"));
		final Integer gradingFormat = Integer.parseInt(req.getParameter("gradeType"));
		final Integer eventType = Integer.parseInt(req.getParameter("eventType"));
		final String justification = req.getParameter("justification");
		final Integer workMissed = Integer.parseInt(req.getParameter("workMissed"));
		Boolean urgent = false;
		//make urgent if less than 2 weeks out
		try {
			if(new SimpleDateFormat("yyyy-MM-dd").parse(eventDate).getTime() - date.getTime() < 1209600000) {
				urgent = true;
			}else {
				urgent = false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		final Integer rankRequired = user.getSupervisor();
		final Integer stage = 0;
		final String timeSubmitted = formatter.format(date);
		final Integer timeInStep = 0;
		final String denyReason = "";
		
		LOGGY.info("userId=" + userId + ", eventName=" + eventName + ", eventDate="
				+ eventDate + ", eventTime=" + eventTime + ", location=" + location + ", description=" + description + ", cost="
				+ cost + ", gradingFormat=" + gradingFormat + ", eventType =" + eventType + ", justification=" + justification + ", workMissed="
				+ workMissed + ", urgent=" + urgent + ", rankRequired=" + rankRequired + ", stage=" + stage
				+ ", timeSubmitted=" + timeSubmitted + ", timeInStep=" + timeInStep + ", denyReason=" + denyReason);
		
		ReimburseReq object = new ReimburseReq(requestId, userId, eventName, eventDate, eventTime, location, description, cost, gradingFormat, eventType, justification, workMissed, urgent, rankRequired, stage, timeSubmitted, timeInStep, denyReason);
		
		//send object to repository layer
		RequestRepositoryImpl reqRepo = new RequestRepositoryImpl();
		reqRepo.insertIntoRequests(object);
	}

	@Override
	public ArrayList<ReimburseReq> getPersonalRequests(HttpServletRequest req, HttpServletResponse resp) {
		//initialize logger
		final Logger LOGGY = LogManager.getLogger(RequestDispatcher.class);
		
		//grab user info from session
		HttpSession session = req.getSession(false);
		User user = (User) session.getAttribute("user");
		
		LOGGY.info("The user attached to the session: " + user);

		RequestRepositoryImpl reqRepo = new RequestRepositoryImpl();		
		return reqRepo.getRequestsByUserId(user);
	}
	
}
