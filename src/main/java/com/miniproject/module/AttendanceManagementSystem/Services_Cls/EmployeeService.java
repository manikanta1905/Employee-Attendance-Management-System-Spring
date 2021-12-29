package com.miniproject.module.AttendanceManagementSystem.Services_Cls;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.miniproject.module.AttendanceManagementSystem.Entity.Leave;
import com.miniproject.module.AttendanceManagementSystem.Entity.LeaveRequest;
import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;

@Service
@Transactional
@Component
public class EmployeeService {


	private final EmpRepo emprepo;
	
//	@Autowired
	private final LeaveService leaveservice;
	
//	@Autowired
//	private ManagerServices managerservice;

	
	@Autowired
	public EmployeeService(@Lazy EmpRepo emprepo,@Lazy LeaveService leaveservice )
	{
		this.emprepo = emprepo;
		this.leaveservice = leaveservice;
	}
	public void addEmployee(Employee emp1) {
		emprepo.save(emp1);
	}

	public Employee updateEmployee(Employee emp) {
		return emprepo.save(emp);
	}
	
	public Optional<Employee> findEmployeeById(int id) {
		return emprepo.findById(id);
	}
	
	public Optional<Employee> getPerticularEmployee(int empid) {
		return emprepo.findById(empid);
	}
	
	public Optional<Employee> findEmployeeByDeptId(int deptid){
		return  emprepo.findById(deptid);
	}
	
//	public Optional<Employee> getEmployee(String emp_email){
//		return emprepo.findByEmail(emp_email);
//	}
	
	public Leave applyForLeave(Leave request) {
		int eid = request.getLeave_id();
		//managerservice.showLeaves(eid);
		return leaveservice.applyLeave(request);
	}
	
	public List<Leave> viewStatus(int empid){
		return leaveservice.checkStatus(empid);
	}

	public List<Employee> findEmployeesByDeptId(int deptid) {
		return emprepo.findAllByDepartment_Deptid(deptid);
	}
/*	
	public Leaves showLeave(LeaveRequest request) {
		
		return 
	}
	*/
}
