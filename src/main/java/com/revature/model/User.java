package com.revature.model;

public class User {
	private Integer userId;
	private String username;
	private String password;
	private String first;
	private String last;
	private Integer rank;
	private Double totalReimbursed;
	private Double pendingReimbursed;
	private Integer supervisor;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String username, String password, String first, String last, Integer rank, Double totalReimbursed,
			Double pendingReimbursed, Integer supervisor) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.first = first;
		this.last = last;
		this.rank = rank;
		this.totalReimbursed = totalReimbursed;
		this.pendingReimbursed = pendingReimbursed;
		this.supervisor = supervisor;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Double getTotalReimbursed() {
		return totalReimbursed;
	}

	public void setTotalReimbursed(Double totalReimbursed) {
		this.totalReimbursed = totalReimbursed;
	}

	public Double getPendingReimbursed() {
		return pendingReimbursed;
	}

	public void setPendingReimbursed(Double pendingReimbursed) {
		this.pendingReimbursed = pendingReimbursed;
	}

	public Integer getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Integer supervisor) {
		this.supervisor = supervisor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		result = prime * result + ((last == null) ? 0 : last.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((pendingReimbursed == null) ? 0 : pendingReimbursed.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((supervisor == null) ? 0 : supervisor.hashCode());
		result = prime * result + ((totalReimbursed == null) ? 0 : totalReimbursed.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		if (last == null) {
			if (other.last != null)
				return false;
		} else if (!last.equals(other.last))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pendingReimbursed == null) {
			if (other.pendingReimbursed != null)
				return false;
		} else if (!pendingReimbursed.equals(other.pendingReimbursed))
			return false;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (supervisor == null) {
			if (other.supervisor != null)
				return false;
		} else if (!supervisor.equals(other.supervisor))
			return false;
		if (totalReimbursed == null) {
			if (other.totalReimbursed != null)
				return false;
		} else if (!totalReimbursed.equals(other.totalReimbursed))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + "username=" + username +", password=" + password + ", first=" + first + ", last=" + last + ", rank="
				+ rank + ", totalReimbursed=" + totalReimbursed + ", pendingReimbursed=" + pendingReimbursed
				+ ", supervisor=" + supervisor + "]";
	}
	
}
