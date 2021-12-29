package com.miniproject.module.AttendanceManagementSystem.Entity;

import java.util.Date;

public class LeaveRequest {

	private int leave_id;
	private int leave_emp_id;
	private String  leave_description;
	private boolean leave_approved;
	private Date date_from = new Date();
	private Date date_to = new Date();
	private int leave_month;
	private int leave_total_days;
	public int getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(int leave_id) {
		this.leave_id = leave_id;
	}
	public int getLeave_emp_id() {
		return leave_emp_id;
	}
	public void setLeave_emp_id(int leave_emp_id) {
		this.leave_emp_id = leave_emp_id;
	}
	public String getLeave_description() {
		return leave_description;
	}
	public void setLeave_description(String leave_description) {
		this.leave_description = leave_description;
	}
	public boolean isLeave_approved() {
		return leave_approved;
	}
	public void setLeave_approved(boolean leave_approved) {
		this.leave_approved = leave_approved;
	}
	public Date getDate_from() {
		return date_from;
	}
	public void setDate_from(Date date_from) {
		this.date_from = date_from;
	}
	public Date getDate_to() {
		return date_to;
	}
	public void setDate_to(Date date_to) {
		this.date_to = date_to;
	}
	public int getLeave_month() {
		return leave_month;
	}
	public void setLeave_month(int leave_month) {
		this.leave_month = leave_month;
	}
	public int getLeave_total_days() {
		return leave_total_days;
	}
	public void setLeave_total_days(int leave_total_days) {
		this.leave_total_days = leave_total_days;
	}
	public LeaveRequest(int leave_id, int leave_emp_id, String leave_description, boolean leave_approved, Date date_from,
			Date date_to, int leave_month, int leave_total_days) {
		super();
		this.leave_id = leave_id;
		this.leave_emp_id = leave_emp_id;
		this.leave_description = leave_description;
		this.leave_approved = leave_approved;
		this.date_from = date_from;
		this.date_to = date_to;
		this.leave_month = leave_month;
		this.leave_total_days = leave_total_days;
	}
	
}
