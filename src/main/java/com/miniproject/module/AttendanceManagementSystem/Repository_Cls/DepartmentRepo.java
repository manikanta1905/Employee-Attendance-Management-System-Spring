package com.miniproject.module.AttendanceManagementSystem.Repository_Cls;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.module.AttendanceManagementSystem.Entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department , Integer> {

	
//	Department AllEmployeeById(int dept_id);
//
//	Department fidById(int id);
//	//List<Department> finAllDept();
//
//	List<Department> finAllDept();

	
}
