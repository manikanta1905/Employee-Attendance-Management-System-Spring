package com.miniproject.module.AttendanceManagementSystem.Repository_Cls;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.module.AttendanceManagementSystem.Entity.RefreshToken;

public interface RefreshTokenRepo extends JpaRepository<RefreshToken , Integer>{

//Optional<RefreshToken> findByToken(String token);
//
//	void deleteByToken(String token);
}
