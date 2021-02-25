package com.synex.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class LeaveApproval {

	@Id
	private int id;
	
	@OneToOne
	@JoinColumn(name="reqId")
	private LeaveRequest LeaveRequestId;
	
	private Status status;
	private int ApprovedBy;
	private LocalDate ApprovedOn;
	
	@Transient
	private int reqid;
	public LeaveApproval() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LeaveRequest getLeaveRequestId() {
		return LeaveRequestId;
	}

	public void setLeaveRequestId(LeaveRequest leaveRequestId) {
		LeaveRequestId = leaveRequestId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getApprovedBy() {
		return ApprovedBy;
	}

	public void setApprovedBy(int approvedBy) {
		ApprovedBy = approvedBy;
	}

	public LocalDate getApprovedOn() {
		return ApprovedOn;
	}

	public void setApprovedOn(LocalDate approvedOn) {
		ApprovedOn = approvedOn;
	}

	public int getReqid() {
		return reqid;
	}

	public void setReqid(int reqid) {
		this.reqid = reqid;
	}
	
	
	
	
}
