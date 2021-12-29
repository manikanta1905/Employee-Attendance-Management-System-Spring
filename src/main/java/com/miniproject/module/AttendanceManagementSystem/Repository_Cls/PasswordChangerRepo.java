package com.miniproject.module.AttendanceManagementSystem.Repository_Cls;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.module.AttendanceManagementSystem.Entity.ChangePassword;
@Repository
public interface PasswordChangerRepo extends JpaRepository<ChangePassword , Integer>{

}
