package com.miniproject.module.AttendanceManagementSystem.Services_Cls;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.miniproject.module.AttendanceManagementSystem.Entity.Attendance_Cls;
import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;
import com.miniproject.module.AttendanceManagementSystem.Entity.Leave;
import com.miniproject.module.AttendanceManagementSystem.Entity.LeaveRequest;

//import Repository_Cls.AttendanceRepo;
import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.ManagerRepo;
///mport java.lang.Long;

@Service
@Transactional
@Component
public class ManagerServices {

	private final ManagerRepo managerrepo;
	private final LeaveService leaveservice;
	private final AttendanceService attendanceservice;

	public ManagerServices(ManagerRepo managerrepo,LeaveService leaveservice,AttendanceService attendanceservice) {
		this.managerrepo = managerrepo;
		this.leaveservice = leaveservice;
		this.attendanceservice = attendanceservice;
	}

//	public ManagerServices(){
//
//	}
	public Employee addEmp(Employee emp) {	
//		String s = UUID.randomUUID().toString();
//		int l = Integer.parseInt(s);
//		emp.setEmp_id(l);
		return managerrepo.save(emp);
	}
	
	public List<Employee> findAllEmployee(){
		return managerrepo.findAll();
	}
	
	
	public Optional<Employee> findEmployeeById(int id) {
		return managerrepo.findById(id);
	}
	
	
	public void deleteEmployee(int emp_id) {
		managerrepo.deleteById(emp_id);
	}
	
	public Optional<Attendance_Cls> viewAttendanceById(int emp_id){
		return attendanceservice.findAttendanceById(emp_id);
	}
	
	public List<Attendance_Cls> viewAttendance(){
		return attendanceservice.viewAttend();
	}

	public List<Leave> showLeaveReq( ) {
		// TODO Auto-generated method stub
		return leaveservice.viewLeaves();
		
	}
	
	public Optional<Leave> getLeaveByEmpid(int empid) {
		return leaveservice.findEmpLeaveById(empid);
	}
	public void  LeaveStatus(LeaveRequest request) {
		leaveservice.LeaveEmpStatus(request);
	}
}
