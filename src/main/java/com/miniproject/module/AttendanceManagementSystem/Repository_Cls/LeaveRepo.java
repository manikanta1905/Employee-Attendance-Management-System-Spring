package com.miniproject.module.AttendanceManagementSystem.Repository_Cls;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.miniproject.module.AttendanceManagementSystem.Entity.Leave;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeaveRepo extends JpaRepository<Leave , Integer>{
//    @Override
//    Optional<Leave> findByEmpId(Integer integer);
//    @Query(value = "SELECT * FROM leave1 l where l.employee_emp_id =:name")
    List<Leave> findAllByEmployee_EmpId(int id);

    List<Leave> findAllByApproved(int Approved);
    //	@Modifying
//	@Query(" update Leave l set l.leave_approved =:status where l.leave_emp_id = :empid ")
//	void LeaveStatus(@Param("leave_approved") boolean leave_approved , @Param("leave_emp_id") Integer leave_emp_id );

	//void LeaveStatus(boolean leave_approved, int leave_emp_id);
}
