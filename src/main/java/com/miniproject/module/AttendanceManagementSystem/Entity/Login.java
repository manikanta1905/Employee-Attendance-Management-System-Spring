package com.miniproject.module.AttendanceManagementSystem.Entity;

//import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import javax.persistence.CascadeType;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false , updatable = false)
	private int login_id ;
	private String username ;
	private String password;

	

	public Login() {
	}

	public Login(int login_id , String username , String password , Employee employee) {
		this.username = username;
		this.password = password;
		this.login_id = login_id;
		this.employee = employee;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
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

   @OneToOne( fetch = FetchType.LAZY , optional = false)
   @JoinColumn(name = "emp_id" , nullable = false)
    private Employee employee;

   public Employee getEmployee() {
	return employee;
   }

   public void setEmployee(Employee employee) {
	   this.employee = employee;
   }

}
