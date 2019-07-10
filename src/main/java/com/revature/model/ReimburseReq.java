package com.revature.model;

public class ReimburseReq {
	private Integer requestId;
	private Integer userId;
	private String eventName;
	private String eventDate;
	private String time;
	private String location;
	private String description;
	private Double cost;
	private Integer gradingFormat;
	private Integer eventType;
	private String justification;
	private Integer workMissed;
	private Boolean urgent;
	private Integer rankRequired;
	private Integer stage;
	private String timeSubmitted;
	private Integer timeInStep;
	private String denyReason;
	
	public ReimburseReq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimburseReq(Integer requestId, Integer userId, String eventName, String eventDate, String time, String location,
			String description, Double cost, Integer gradingFormat, Integer eventType, String justification, Integer workMissed,
			Boolean urgent, Integer rankRequired, Integer stage, String timeSubmitted, Integer timeInStep,
			String denyReason) {
		super();
		this.requestId = requestId;
		this.userId = userId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.time = time;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.justification = justification;
		this.workMissed = workMissed;
		this.urgent = urgent;
		this.rankRequired = rankRequired;
		this.stage = stage;
		this.timeSubmitted = timeSubmitted;
		this.timeInStep = timeInStep;
		this.denyReason = denyReason;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Integer getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(Integer gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Integer getWorkMissed() {
		return workMissed;
	}

	public void setWorkMissed(Integer workMissed) {
		this.workMissed = workMissed;
	}

	public Boolean getUrgent() {
		return urgent;
	}

	public void setUrgent(Boolean urgent) {
		this.urgent = urgent;
	}

	public Integer getRankRequired() {
		return rankRequired;
	}

	public void setRankRequired(Integer rankRequired) {
		this.rankRequired = rankRequired;
	}

	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}

	public String getTimeSubmitted() {
		return timeSubmitted;
	}

	public void setTimeSubmitted(String timeSubmitted) {
		this.timeSubmitted = timeSubmitted;
	}

	public Integer getTimeInStep() {
		return timeInStep;
	}

	public void setTimeInStep(Integer timeInStep) {
		this.timeInStep = timeInStep;
	}

	public String getDenyReason() {
		return denyReason;
	}

	public void setDenyReason(String denyReason) {
		this.denyReason = denyReason;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((denyReason == null) ? 0 : denyReason.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((eventName == null) ? 0 : eventName.hashCode());
		result = prime * result + ((gradingFormat == null) ? 0 : gradingFormat.hashCode());
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((rankRequired == null) ? 0 : rankRequired.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((stage == null) ? 0 : stage.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((timeInStep == null) ? 0 : timeInStep.hashCode());
		result = prime * result + ((timeSubmitted == null) ? 0 : timeSubmitted.hashCode());
		result = prime * result + ((urgent == null) ? 0 : urgent.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((workMissed == null) ? 0 : workMissed.hashCode());
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
		ReimburseReq other = (ReimburseReq) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (denyReason == null) {
			if (other.denyReason != null)
				return false;
		} else if (!denyReason.equals(other.denyReason))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (eventName == null) {
			if (other.eventName != null)
				return false;
		} else if (!eventName.equals(other.eventName))
			return false;
		if (gradingFormat == null) {
			if (other.gradingFormat != null)
				return false;
		} else if (!gradingFormat.equals(other.gradingFormat))
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (rankRequired == null) {
			if (other.rankRequired != null)
				return false;
		} else if (!rankRequired.equals(other.rankRequired))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (stage == null) {
			if (other.stage != null)
				return false;
		} else if (!stage.equals(other.stage))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (timeInStep == null) {
			if (other.timeInStep != null)
				return false;
		} else if (!timeInStep.equals(other.timeInStep))
			return false;
		if (timeSubmitted == null) {
			if (other.timeSubmitted != null)
				return false;
		} else if (!timeSubmitted.equals(other.timeSubmitted))
			return false;
		if (urgent == null) {
			if (other.urgent != null)
				return false;
		} else if (!urgent.equals(other.urgent))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (workMissed == null) {
			if (other.workMissed != null)
				return false;
		} else if (!workMissed.equals(other.workMissed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", userId=" + userId + ", eventName=" + eventName + ", eventDate="
				+ eventDate + ", time=" + time + ", location=" + location + ", description=" + description + ", cost="
				+ cost + ", gradingFormat=" + gradingFormat + ", justification=" + justification + ", workMissed="
				+ workMissed + ", urgent=" + urgent + ", rankRequired=" + rankRequired + ", stage=" + stage
				+ ", timeSubmitted=" + timeSubmitted + ", timeInStep=" + timeInStep + ", denyReason=" + denyReason
				+ "]";
	}

	public Integer getEventType() {
		return eventType;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}
}
