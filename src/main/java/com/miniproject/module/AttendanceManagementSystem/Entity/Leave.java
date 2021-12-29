package com.miniproject.module.AttendanceManagementSystem.Entity;
import org.hibernate.annotations.ColumnDefault;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name ="Leave1")
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false , updatable = false)
	private int leave_id;
	//private int leave_emp_id;
	private String  leave_description;
	@ColumnDefault("0")
	private int approved;
	private String date_from ;
	private String date_to ;
	private String leave_month;
	private int leave_total_days;
	@ManyToOne
	private Employee employee;

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

//	public int isApproved() {
//		return approved;
//	}
//
//	public void setApproved(int approved) {
//		this.approved = approved;
//	}

	

	public Leave() {

	}

	public int getApproved() {
		return approved;
	}

	public void setApproved(int approved) {
		this.approved = approved;
	}

	public int getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(int leave_id) {
		this.leave_id = leave_id;
	}
/*	public int getLeave_emp_id() {
		return leave_emp_id;
	}
	public void setLeave_emp_id(int leave_emp_id) {
		this.leave_emp_id = leave_emp_id;
	}
*/public String getLeave_description() {
		return leave_description;
	}
	public void setLeave_description(String leave_description) {
		this.leave_description = leave_description;
	}
	public int isLeave_approved() {
		return approved;
	}
	public void setLeave_approved(int leave_approved) {
		this.approved = leave_approved;
	}
	public String getDate_from() {
		return date_from;
	}
	public void setDate_from(String date_from) {
		this.date_from = date_from;
	}
	public String getDate_to() {
		return date_to;
	}
	public void setDate_to(String date_to) {
		this.date_to = date_to;
	}
	public String getLeave_month() {
		return leave_month;
	}
	public void setLeave_month(String leave_month) {
		this.leave_month = leave_month;
	}
	public int getLeave_total_days() {
		return leave_total_days;
	}
	public void setLeave_total_days(int leave_total_days) {
		this.leave_total_days = leave_total_days;
	}
	public Leave(int leave_id, String leave_description, int leave_approved, String date_from,
			String date_to, String leave_month, int leave_total_days, Employee employee) {
		this.leave_id = leave_id;
		//this.leave_emp_id = leave_emp_id;
		this.leave_description = leave_description;
		this.approved = leave_approved;
		this.date_from = date_from;
		this.date_to = date_to;
		this.leave_month = leave_month;
		this.leave_total_days = leave_total_days;
		this.employee = employee;
	}
	


	
	
}
