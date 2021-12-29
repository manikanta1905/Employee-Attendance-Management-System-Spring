package com.miniproject.module.AttendanceManagementSystem.Entity;

import java.util.Date;

public class AttendanceRequest {
	private int att_id;
	private int att_emp_id;
	private int attend_totals_days;
	private int att_month;
	private Date date_form = new Date();
	private Date att_date_to = new Date();
	private int total_att_marked;
	private int att_not_marked;
	
	public AttendanceRequest(int att_id, int att_emp_id, int attend_totals_days, int att_month, Date date_form,
			Date att_date_to, int total_att_marked, int att_not_marked) {
		super();
		this.att_id = att_id;
		this.att_emp_id = att_emp_id;
		this.attend_totals_days = attend_totals_days;
		this.att_month = att_month;
		this.date_form = date_form;
		this.att_date_to = att_date_to;
		this.total_att_marked = total_att_marked;
		this.att_not_marked = att_not_marked;
	}
	public int getAtt_id() {
		return att_id;
	}
	public void setAtt_id(int att_id) {
		this.att_id = att_id;
	}
	public int getAtt_emp_id() {
		return att_emp_id;
	}
	public void setAtt_emp_id(int att_emp_id) {
		this.att_emp_id = att_emp_id;
	}
	public int getAttend_totals_days() {
		return attend_totals_days;
	}
	public void setAttend_totals_days(int attend_totals_days) {
		this.attend_totals_days = attend_totals_days;
	}
	public int getAtt_month() {
		return att_month;
	}
	public void setAtt_month(int att_month) {
		this.att_month = att_month;
	}
	public Date getDate_form() {
		return date_form;
	}
	public void setDate_form(Date date_form) {
		this.date_form = date_form;
	}
	public Date getAtt_date_to() {
		return att_date_to;
	}
	public void setAtt_date_to(Date att_date_to) {
		this.att_date_to = att_date_to;
	}
	public int getTotal_att_marked() {
		return total_att_marked;
	}
	public void setTotal_att_marked(int total_att_marked) {
		this.total_att_marked = total_att_marked;
	}
	public int getAtt_not_marked() {
		return att_not_marked;
	}
	public void setAtt_not_marked(int att_not_marked) {
		this.att_not_marked = att_not_marked;
	}
	
}
