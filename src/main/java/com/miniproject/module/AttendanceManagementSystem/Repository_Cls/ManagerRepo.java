package com.miniproject.module.AttendanceManagementSystem.Repository_Cls;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface ManagerRepo extends JpaRepository<Employee , Integer> {

//	List<Employee> findAll();

	//Employee findEmployeeById(Long id);

//	Employee findEmployeeById(int id);

}
