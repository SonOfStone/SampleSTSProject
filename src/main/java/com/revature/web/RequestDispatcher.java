package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class RequestDispatcher
 */
public class RequestDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RequestDispatcher() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//grabs the httpverb associated with the request.		
		final String HTTPMETHOD = request.getMethod();
		
		if(HTTPMETHOD.contentEquals("GET")) {
			response.getOutputStream().write(new ObjectMapper().writeValueAsBytes(RequestHelper.processGet(request, response)));
		}else {
			response.getOutputStream().write(new ObjectMapper().writeValueAsBytes(RequestHelper.processPost(request, response)));
		}
	}

}
