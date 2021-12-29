package com.miniproject.module.AttendanceManagementSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan("com.miniproject.module.AttendanceManagementSystem.Entity")
@EnableJpaRepositories("com.miniproject.module.AttendanceManagementSystem.Repository_Cls")
@RestController
public class AttendanceManagementSystemApplication extends SpringBootServletInitializer {

	
//	@RequestMapping("/resource")
//	  public Map<String,Object> home() {
//	    Map<String,Object> model = new HashMap<String,Object>();
//	    model.put("id", UUID.randomUUID().toString());
//	    model.put("content", "Hello World");
//	    return model;
//	  }

	public static void main(String[] args) {
		SpringApplication.run(AttendanceManagementSystemApplication.class, args);
	}

}
