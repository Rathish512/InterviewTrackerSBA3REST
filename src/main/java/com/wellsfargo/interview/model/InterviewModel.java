package com.wellsfargo.interview.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class InterviewModel {

	@NotNull(message = "interviewId is mandatory")
	private Integer interviewId;
	
	@NotNull(message = "Interviewer name is mandatory")
	@NotBlank(message = "Interviewer name is mandatory")
	@Size(min=5,max=30,message = "Interviewer name should be between 5 to 30 characters")
	private String interviewerName;
	
	@NotNull(message = "Interview name is mandatory")
	@NotBlank(message = "Interview name is mandatory")
	@Size(min=3,max=30,message = "Interview name should be between 3 to 30 characters")
	private String interviewName;
	
	@NotNull(message = "Users Skills are mandatory")
	@NotBlank(message = "Users Skills are mandatory")
	@Size(min=5,max=30,message = "Users Skills should be between 5 to 30 characters")
	private String usersSkills;
	
	@NotNull(message = "Time is mandatory")
	@DateTimeFormat(iso=ISO.TIME)
	private LocalTime time;
	
	@NotNull(message = "Date is mandatory")
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate date;
	
	@NotNull(message = "Interview Status is mandatory")
	@NotBlank(message = "Interview Status is mandatory")
	@Size(min=5,max=100,message = "Interview status should be between 5 to 100 characters")
	private String interviewStatus;
	
	@NotNull(message = "Remarks is mandatory")
	@NotBlank(message = "Remarks is mandatory")
	@Size(min=5,max=100,message = "Remarks should be between 5 to 100 characters")
	private String remarks;
	
	public InterviewModel()
	{
		
	}

	public InterviewModel(Integer interviewId, String interviewerName, String interviewName, String usersSkills,
			LocalTime time, LocalDate date, String interviewStatus, String remarks) {
		super();
		this.interviewId = interviewId;
		this.interviewerName = interviewerName;
		this.interviewName = interviewName;
		this.usersSkills = usersSkills;
		this.time = time;
		this.date = date;
		this.interviewStatus = interviewStatus;
		this.remarks = remarks;
	}

	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public String getInterviewerName() {
		return interviewerName;
	}

	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}

	public String getInterviewName() {
		return interviewName;
	}

	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}

	public String getUsersSkills() {
		return usersSkills;
	}

	public void setUsersSkills(String usersSkills) {
		this.usersSkills = usersSkills;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getInterviewStatus() {
		return interviewStatus;
	}

	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "InterviewEntity [interviewId=" + interviewId + ", interviewerName=" + interviewerName
				+ ", interviewName=" + interviewName + ", usersSkills=" + usersSkills + ", time=" + time + ", date="
				+ date + ", interviewStatus=" + interviewStatus + ", remarks=" + remarks + "]";
	}
	
}
