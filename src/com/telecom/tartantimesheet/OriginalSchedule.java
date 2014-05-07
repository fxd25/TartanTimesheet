package com.telecom.tartantimesheet;

import java.sql.*;

public class OriginalSchedule {

	String day;
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	Time startTime;
	Time endTime;
	
	public OriginalSchedule(){
		
	}
	
	public OriginalSchedule(String day, Time startTime, Time endTime){
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
}
