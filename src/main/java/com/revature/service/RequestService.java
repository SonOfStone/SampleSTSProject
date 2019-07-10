package com.revature.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.ReimburseReq;

public interface RequestService {
	void insertRequest(HttpServletRequest req, HttpServletResponse resp);
	ArrayList<ReimburseReq> getPersonalRequests(HttpServletRequest req, HttpServletResponse resp);
}
