//package com.miniproject.module.AttendanceManagementSystem.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.miniproject.module.AttendanceManagementSystem.Entity.PasswordChangerRequest;
//
//import Services_Cls.EmployeeService;
//import Services_Cls.PasswordChangerService;
//import Services_Cls.RefreshTokenService;
//
//@RestController
//@RequestMapping("/changepass")
//public class ChangePassController {
//
//	 private EmployeeService empservice;
//	 private PasswordChangerService passchangerservice;
//	 private RefreshTokenService refreshtokenservice;
//
//
//
//	public ChangePassController(EmployeeService empservice , PasswordChangerService passchangerservice , RefreshTokenService refreshtokenservice) {
//		 this.empservice = empservice;
//		 this.passchangerservice = passchangerservice;
//		 this.refreshtokenservice =  refreshtokenservice;
//	 }
//
//	 public ChangePassController()
//	 {
//
//	 }
//
//	 @PostMapping("/forgotpassword")
//	 public ResponseEntity<HttpStatus> forgotPassword(@RequestBody PasswordChangerRequest request){
//		 passchangerservice.addVerification(request.getEmail());
//		 return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//	 }
//
//	 @PostMapping("/updatepassword")
//	 public String passwordChanger(@RequestBody PasswordChangerRequest request ) {
//		 passchangerservice.changePassword(request);
//		 return "Password changed ssuccessfully";
//	 }
//}
