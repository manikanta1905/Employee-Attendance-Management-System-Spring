package com.miniproject.module.AttendanceManagementSystem.Services_Cls;

import java.time.Instant;
import java.util.UUID;

import javax.transaction.Transactional;

import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.RefreshTokenRepo;
import org.springframework.stereotype.Service;
//import org.slf4j.LoggerFactory;

import com.miniproject.module.AttendanceManagementSystem.Entity.RefreshToken;

import com.miniproject.module.AttendanceManagementSystem.exception.AttendanceException;
//import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class RefreshTokenService {

//	private static final Logger log  = LoggerFactory.getLogger(RefreshTokenService.class);
	private RefreshTokenRepo refreshtokenrepo;
	
	RefreshToken generateRefreshoken() {
		RefreshToken refreshtoken = new RefreshToken();
		refreshtoken.setToken(UUID.randomUUID().toString());
		refreshtoken.setCreatedDate(Instant.now());
		
		return refreshtokenrepo.save(refreshtoken);
	}
	
//	void validateRefreshToken(String token) {
//		refreshtokenrepo.findByToken(token).orElseThrow( () -> {
//			//log.error(" Invalid Refresh Token");
//			System.out.println("Invalid Resfresh  Token");
//			return new AttendanceException("Invalid Refresh token");
//		}) ;
//
//	}
//
//	public void deleteRefreshToke(String token) {
//		refreshtokenrepo.deleteByToken(token);
//		//log.info(" Token Deleted Successfully");
//
//	}
}
