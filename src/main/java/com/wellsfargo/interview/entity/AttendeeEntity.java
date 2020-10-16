package com.wellsfargo.interview.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="attendee")
@Entity
public class AttendeeEntity {

	@Id
	@Column
	private Integer attendeeId;
	
	@ManyToOne
    @JoinColumn(name = "user_Id")
	private UserEntity User;
	
	@ManyToOne
    @JoinColumn(name = "interview_Id")
	private InterviewEntity Interview;
	
	public AttendeeEntity()
	{
		
	}

	public Integer getAttendeeId() {
		return attendeeId;
	}

	public void setAttendeeId(Integer attendeeId) {
		this.attendeeId = attendeeId;
	}

	public UserEntity getUser() {
		return User;
	}

	public void setUser(UserEntity user) {
		User = user;
	}

	public InterviewEntity getInterview() {
		return Interview;
	}

	public void setInterview(InterviewEntity interview) {
		Interview = interview;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InterviewEntity other = (InterviewEntity) obj;
        if (this.Interview.getInterviewId() == null) {
            if (other.getInterviewId() != null)
                return false;
        } else if (!this.Interview.getInterviewId().equals(other.getInterviewId()))
            return false;
        return true;
    }

	public AttendeeEntity(Integer attendeeId, UserEntity user, InterviewEntity interview) {
		super();
		this.attendeeId = attendeeId;
		User = user;
		Interview = interview;
	}
	
	

}
