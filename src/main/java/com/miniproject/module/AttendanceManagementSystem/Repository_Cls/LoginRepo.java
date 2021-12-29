package com.miniproject.module.AttendanceManagementSystem.Repository_Cls;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.miniproject.module.AttendanceManagementSystem.Entity.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login , Long> {

	Login findByUsername(String Username);
	Login findByPassword(String Password);
	

}
