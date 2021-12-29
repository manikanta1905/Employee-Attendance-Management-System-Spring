package com.miniproject.module.AttendanceManagementSystem.Services_Cls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.miniproject.module.AttendanceManagementSystem.Entity.Leave;
import com.miniproject.module.AttendanceManagementSystem.Entity.LeaveRequest;

import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.LeaveRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Component
public class LeaveService {

	private final LeaveRepo leaverepo;
	
	public LeaveService(LeaveRepo leaverepo) {
		this.leaverepo = leaverepo;
	}

	Leave ll ;
	public Leave applyLeave(Leave request) {
		
//		int eid = request.getLeave_id() ;
//		ll.setLeave_id(eid);
		leaverepo.save(request);
		
		return request;
	}
	
	public List<Leave> viewLeaves(){
		return leaverepo.findAll();
	}
	
	public Optional<Leave> findEmpLeaveById(int empid) {
		return leaverepo.findById(empid);
	}
	
	public void LeaveEmpStatus(LeaveRequest request){
		boolean leave_approved = request.isLeave_approved();
		int leave_emp_id = request.getLeave_emp_id();
//		leaverepo.LeaveStatus(leave_approved , leave_emp_id);
	}
	
	public List<Leave> checkStatus(int empid) {
		List<Leave> L =  leaverepo.findAllByEmployee_EmpId(empid);

		return L;
	}

	public List<Leave> getLeaveByAccepted() {
		return leaverepo.findAllByApproved(1);
	}

	public List<Leave> getLeaveByNotAccepted() {
		return leaverepo.findAllByApproved(0);
	}

	public Leave approveLeave(int leaveid) {
		Optional<Leave> ll = leaverepo.findById(leaveid);
		if(ll.isPresent()){
			Leave lv = ll.get();
			lv.setLeave_approved(1);
			leaverepo.save(lv);
			return lv;
		}
		else
			return null;
	}
	
	public Leave declinedLeave(int leaveid) {
		Optional<Leave> ll = leaverepo.findById(leaveid);
		if(ll.isPresent()){
			Leave lv = ll.get();
			lv.setLeave_approved(-1);
			leaverepo.save(lv);
			return lv;
		}
		else
			return null;
	}
	
	
}
