package com.miniproject.module.AttendanceManagementSystem.Services_Cls;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.AttendanceRepo;
import org.springframework.stereotype.Service;

import com.miniproject.module.AttendanceManagementSystem.Entity.AttendanceRequest;
import com.miniproject.module.AttendanceManagementSystem.Entity.Attendance_Cls;

@Service
@Transactional
public class AttendanceService {

	private AttendanceRepo attendancerepo;
	
	public AttendanceService( AttendanceRepo attendancerepo) {
		this.attendancerepo = attendancerepo;
	}
	


	public void apply_Attendance(Attendance_Cls request) {
		
//		int aid = request.getAtt_emp_id();
//		att.setAtt_id(aid);
		 attendancerepo.save(request);
	}
	
	public Optional<Attendance_Cls> findAttendanceById(int emp_id) {

		return attendancerepo.findById(emp_id);

	}
	
	public List<Attendance_Cls> viewAttend(){
		return  attendancerepo.findAll();
	}

	public List<Attendance_Cls> viewByEmpId(int empid) {
		return attendancerepo.findAllByEmployee_EmpId(empid);
	}

}

