package com.miniproject.module.AttendanceManagementSystem.Entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.*;

//@Configuration
@Entity
@Table(name ="Employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY  )
	@Column(nullable = false , updatable = false)
	private int empId;
	private String emp_name;
	private String emp_designation;
	private String emp_doj;
	//private int emp_dept_id;
	private String emp_mobile;
	private String emp_email;
//	private String emp_password;

//	private String empcode;

//	@Bean
//	public EmployeeService employeeService(){
//		return new EmployeeService();
//	}
	Employee(int emp_id , String emp_name,Department department ,String emp_designation , String emp_doj , int emp_deptment , String emp_mobile , String emp_email ){
		this.empId = emp_id ;
		this.emp_name = emp_name ;
		this.emp_designation = emp_designation;
		this.emp_doj = emp_doj;
		this.department = department;
		//this.emp_dept_id = emp_deptment;
		this.emp_mobile = emp_mobile;
		this.emp_email = emp_email;
	//	this.empcode = empcode;
//		this.emp_password = emp_password;
	}



	public Employee() {

	}

	public int getEmp_id() {
		return empId;
	}

	public void setEmp_id(int l) {
		this.empId = l;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_designation() {
		return emp_designation;
	}

	public void setEmp_designation(String emp_designation) {
		this.emp_designation = emp_designation;
	}

	public String getEmp_doj() {
		return emp_doj;
	}

	public void setEmp_doj(String emp_doj) {
		this.emp_doj = emp_doj;
	}

	

	public String getEmp_mobile() {
		return emp_mobile;
	}

	public void setEmp_mobile(String emp_mobile) {
		this.emp_mobile = emp_mobile;
	}

	public String getEmp_email() {
		return emp_email;
		
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	
	@ManyToOne
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

//	public Set<Attendance_Cls> getAttc() {
//		return attc;
//	}
//
//	public void setAttc(Set<Attendance_Cls> attc) {
//		this.attc = attc;
//	}

	@OneToMany(mappedBy = "employee" , cascade=CascadeType.REMOVE)
   // @JoinColumn(name = "att_id")
    private Set<Attendance_Cls> attc = new HashSet<>();
	
    @OneToMany(mappedBy = "employee" , cascade=CascadeType.REMOVE)
   // @JoinColumn(name = "emp_id")
    private Set<Leave> leaves = new HashSet<>();

    
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "employee")
//    @JoinColumn(name = "login_id")
    private Login login;
/*
	public void setEmpcode(String empcode) {
		// TODO Auto-generated method stub
		this.empcode = empcode;
	}
	
	public String getEmpCode() {
		return empcode;
	}
	*/
	@Override
	public String toString() {
		
		return " Employee{" +" id = " + empId +
				", name = "+ emp_name +  " / " + 
				" , Designation = " + emp_designation + '/' +
				" ,  Date _of_Joining = " + emp_doj + '/' +
				//", employee_department_id = " + emp_dept_id + '/' +
				", Mobile = " + emp_mobile + '/' +
				", Email = " + emp_email + '/' +
				"}; " ;
	}

}
