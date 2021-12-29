package com.miniproject.module.AttendanceManagementSystem.Entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class VarificationToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String token ;
	@OneToOne( fetch = FetchType.LAZY)
	private Employee emp;
	private Instant expiryDate;
	
}
