package com.revature.repository;

import java.util.ArrayList;

import com.revature.model.ReimburseReq;
import com.revature.model.User;

public interface RequestRepository {
	void insertIntoRequests(ReimburseReq reimburseReq);
	ArrayList<ReimburseReq> getRequestsByUserId(User user);
}
