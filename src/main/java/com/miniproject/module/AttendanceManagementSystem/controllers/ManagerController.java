package com.miniproject.module.AttendanceManagementSystem.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import com.miniproject.module.AttendanceManagementSystem.Entity.*;
import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.EmpRepo;
import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.ManagerRepo;
import com.miniproject.module.AttendanceManagementSystem.Services_Cls.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import Repository_Cls.DepartmentRepo;

import javax.persistence.PostUpdate;

//@Component
@CrossOrigin("http://localhost:4200")
@Configuration
@RestController
@RequestMapping("/manager/")
public class ManagerController {

	private final ManagerServices managerservices;
	private final DepartmentService deptservice ;
	private final LeaveService leaveService;
	private final EmployeeService employeeService;
	private final AttendanceService attendanceService;
	

	public ManagerController(@Lazy ManagerServices managerservices ,@Lazy DepartmentService deptservice,@Lazy LeaveService leaveService,@Lazy EmployeeService employeeService,@Lazy AttendanceService attendanceService) {
		this.managerservices = managerservices;
		this.deptservice = deptservice;
		this.leaveService = leaveService;
		this.employeeService = employeeService;
		this.attendanceService = attendanceService;
	}

	//get all employees
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> emp = managerservices.findAllEmployee();
		return new ResponseEntity<>(emp , HttpStatus.OK);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		Optional<Employee> emp = managerservices.findEmployeeById(id);
		Employee em;
		if(emp.isPresent())
			em= emp.get();
		else
			em = null;
		return new ResponseEntity<>(em , HttpStatus.OK);
	}
	
	@Autowired
	private EmpRepo emprepo;
	
	@PostMapping("/add/{id}")
	public ResponseEntity<Employee> addEmployee(@PathVariable("id") int id ,@RequestBody Employee employee){
		Employee em = new Employee();
		em.setEmp_name(employee.getEmp_name());
		em.setEmp_designation(employee.getEmp_designation());
		em.setEmp_mobile(employee.getEmp_mobile());
		em.setEmp_email(employee.getEmp_email());
		em.setDepartment(new Department());
		em.getDepartment().setDept_id(id);
		return new ResponseEntity<>(emprepo.save(em),HttpStatus.OK);
//		System.out.println(employee);
		
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delEmp(@PathVariable("id") int id){
		managerservices.deleteEmployee(id);
		return new ResponseEntity<>("Deleted",HttpStatus.OK); 
	}
	
	@GetMapping("/alldept") // for displaying all department
	public ResponseEntity<List<Department>> allDepartment(){

		List<Department> dpt = deptservice.finAllDept();
		return new ResponseEntity<>(dpt,HttpStatus.OK);
		}
	
	@GetMapping("/alldeptEmployee/{deptid}")
	public ResponseEntity<List<Employee>> findEmployeesByDeptId(@PathVariable("deptid") int deptid){
		List<Employee> employee = employeeService.findEmployeesByDeptId(deptid);
		return new ResponseEntity<>(employee , HttpStatus.OK);
	}
	@GetMapping("/attendanceview/{empid}")
	public ResponseEntity<List<Attendance_Cls>> viewAttendanceByIds(@PathVariable("empid") int empid){
		List<Attendance_Cls> newAttendance = attendanceService.viewByEmpId(empid);
//		Attendance_Cls at;
//		if(newAttendance.isPresent())
//			at= newAttendance.get();
//		else
//			at = null;
		return new ResponseEntity<>(newAttendance, HttpStatus.OK);
	}
	
	@GetMapping("/allAttendance")
	public ResponseEntity<List<Attendance_Cls>> viewAttendance(){
		List<Attendance_Cls> attendancess =  managerservices.viewAttendance();
		return new ResponseEntity<>(attendancess ,HttpStatus.OK);
	}
	
	/*
	 
	@GetMapping("/alldept/id/{empid} ")
	public ResponseEntity<Employee> selectPerticularEmployee(@PathVariable("empid") Long empid){
		Employee e = employeeservice.getPerticularEmp(empid);
		return new ResponseEntity<>(e , HttpStatus.OK);
	}
	*/
	@GetMapping("/showLeaves")
	public ResponseEntity<List<Leave>> showLeave(){
		List<Leave> ll = managerservices.showLeaveReq();
		return new ResponseEntity<>(ll , HttpStatus.OK);
	}
	@GetMapping("/showleave/approved")
	public ResponseEntity<List<Leave>> showAcceptedEmpLeave(){
		List<Leave> ll = leaveService.getLeaveByAccepted();
		return new ResponseEntity<>(ll , HttpStatus.OK);
	}
	@GetMapping("/showleave/pending")
	public ResponseEntity<List<Leave>> showNotAcceptedEmpLeave(){
		List<Leave> ll = leaveService.getLeaveByNotAccepted();
		return new ResponseEntity<>(ll , HttpStatus.OK);
	}

	@GetMapping("/showleave/{empid}")
	public ResponseEntity<List<Leave>> showEmpLeave(@PathVariable("empid") int empid){
		List<Leave> ll = leaveService.checkStatus(empid);

		return new ResponseEntity<>(ll , HttpStatus.OK);
	}
	@PutMapping("/approveLeave")
	public ResponseEntity<Leave> approveLeave(@RequestBody int request)
	{
		Leave lv = leaveService.approveLeave(request);
		return new ResponseEntity<>(lv,HttpStatus.OK);
	}
	
	@PutMapping("/declined")
	public ResponseEntity<Leave> declineLeave(@RequestBody int request)
	{
		Leave lv = leaveService.declinedLeave(request);
		return new ResponseEntity<>(lv,HttpStatus.OK);
	}
//	@PostMapping("/showleave/empid")
//	public void AcceptLeave(@RequestBody LeaveRequest request){
//		managerservices.LeaveStatus(request);
//	}
	@DeleteMapping("/DeleteDept/{deptid}")
	public ResponseEntity<String> deletedepartment(@PathVariable("deptid") int deptid)
	{
		deptservice.deleteDepartment(deptid);
		return new ResponseEntity<>("Deleted",HttpStatus.OK);
	}

	@PostMapping("/addDept")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department)
	{
		Department dp = deptservice.addDept(department);
		return new ResponseEntity<>(dp,HttpStatus.OK);
	}

}
