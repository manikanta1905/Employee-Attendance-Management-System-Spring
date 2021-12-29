package com.miniproject.module.AttendanceManagementSystem.controllers;


import java.util.List;
import java.util.Optional;

import com.miniproject.module.AttendanceManagementSystem.Entity.*;
import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.EmpRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.miniproject.module.AttendanceManagementSystem.Entity.Login;

import com.miniproject.module.AttendanceManagementSystem.Services_Cls.AttendanceService;
import com.miniproject.module.AttendanceManagementSystem.Services_Cls.EmployeeService;
//import Services_Cls.LoginService;
@CrossOrigin("http://localhost:4200")
@Configuration
@RestController
@RequestMapping("/employee/")
public class EmployeeController {

	
	private final AttendanceService attendanceservice;
	private final EmployeeService empservice;

	public EmployeeController(@Lazy AttendanceService attendanceservice, @Lazy EmployeeService empservice) {
		this.attendanceservice = attendanceservice;
		this.empservice = empservice;
		
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getInformation(@PathVariable("id") int id){
		Optional<Employee> emp = empservice.findEmployeeById(id);
		return new ResponseEntity<>(emp , HttpStatus.OK);
	}
	
	@Autowired
	private EmpRepo emprepo; 
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable int id ,@RequestBody Employee emp){
		Employee e = emprepo.findByEmpId(id);
		e.setEmp_name(emp.getEmp_name());
		e.setEmp_email(emp.getEmp_email());
		e.setEmp_mobile(emp.getEmp_mobile());
		
		emprepo.save(e);
//		Employee ee = empservice.updateEmployee(emp);
		return new ResponseEntity<>(e , HttpStatus.OK);
	}
	
	@PostMapping("/markAttendance/{id}")
	public ResponseEntity<Attendance_Cls> markAttendance(@PathVariable int id, @RequestBody Attendance_Cls request) {
		
		Attendance_Cls aa = new Attendance_Cls();
		aa.setAtt_date_to(request.getAtt_date_to());
		aa.setAtt_month(request.getAtt_month());
		aa.setDate_form(request.getDate_form());
		aa.setEmployee(new Employee());
		aa.getEmployee().setEmp_id(id);
		attendanceservice.apply_Attendance(aa);
			
			return new ResponseEntity<>(aa,HttpStatus.OK);
	}
	
	
	

	@PostMapping("/requestLeave/{id}")
	public ResponseEntity<Leave> ApplyForLeave(@PathVariable int id,@RequestBody Leave request ) {
		System.out.println("Hello");
		request.setEmployee(new Employee());
		request.getEmployee().setEmp_id(id);
		
		Leave lv =  empservice.applyForLeave(request);
		return new ResponseEntity<>(lv , HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllLeaves/{empid}")
	public ResponseEntity<List<Leave>> ViewStatusForLeave(@PathVariable("empid") int empid) {
		List<Leave> l = empservice.viewStatus(empid);
		
//		Leave lv;
//		if(l.isPresent())
//		lv= l.get();
//		else
//			lv = null;
		return new ResponseEntity<>(l,HttpStatus.OK);
	}
	@GetMapping("/getAttendance/{empid}")
	public ResponseEntity<List<Attendance_Cls>> getAttendance(@PathVariable("empid") int empid){
		List<Attendance_Cls> at = attendanceservice.viewByEmpId(empid);
		return new ResponseEntity<>(at,HttpStatus.OK);

	}
}

 