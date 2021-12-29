package com.miniproject.module.AttendanceManagementSystem.Entity;
import javax.validation.constraints.NotBlank;

public class RefreshTokenRequest {

	@NotBlank
	private String refreshtoken;
	private String email;
}
