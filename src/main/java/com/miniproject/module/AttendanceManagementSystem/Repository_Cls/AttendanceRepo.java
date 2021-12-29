package com.miniproject.module.AttendanceManagementSystem.Repository_Cls;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.module.AttendanceManagementSystem.Entity.Attendance_Cls;

public interface AttendanceRepo extends JpaRepository<Attendance_Cls , Integer> {
    List<Attendance_Cls> findAllByEmployee_EmpId(int empid);
    



	
}
