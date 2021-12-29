package com.miniproject.module.AttendanceManagementSystem.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;
import com.miniproject.module.AttendanceManagementSystem.Entity.Login;
import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.LoginRepo;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/user/")
public class LoginController {

	@Autowired
	private LoginRepo loginrepo;
	
	@PostMapping("/login")
	public ResponseEntity<Employee> home(@RequestBody Login login, HttpServletResponse res)throws IOException {
		String username = login.getUsername();
		String password = login.getPassword();
		
		try {
			Login l1 = loginrepo.findByUsername(username);
			if(l1.getPassword().equals(password) && l1.getUsername().equals(username))
			{
				Employee e = l1.getEmployee();
				int id = e.getEmp_id();
				System.out.println(e);
				return new ResponseEntity<>(e,HttpStatus.OK);
			}
		}catch(Exception e) {
			res.sendRedirect("/notAllowed");
			return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
		}
		
		return new ResponseEntity<>(null,HttpStatus.EXPECTATION_FAILED);
	}
	
	
	
	@GetMapping("/notAllowed")
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public String notFound() {
		return "";
	}
	
	
	
}
