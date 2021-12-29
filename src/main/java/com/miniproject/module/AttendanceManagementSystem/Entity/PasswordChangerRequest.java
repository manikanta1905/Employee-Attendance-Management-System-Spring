package com.miniproject.module.AttendanceManagementSystem.Entity;



public class PasswordChangerRequest {
	
	private String email;
	private String token;
	private String password;
	
	public PasswordChangerRequest() {}
	
	public PasswordChangerRequest(String email , String token , String password) {
		this.email = email;
		this.token = token;
		this.password = password;
		
	}

	public String getToken() {
		// TODO Auto-generated method stub
		return token;
	}

	public Object getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
