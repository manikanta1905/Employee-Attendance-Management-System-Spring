package com.miniproject.module.AttendanceManagementSystem.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false , updatable = false)
	private int deptid;
	private String dept_name;
	private int dept_total_employee;
	@OneToMany(mappedBy = "department" , cascade=CascadeType.REMOVE)
	//@JoinColumn(name = "dept_id")
	private Set<Employee> employees= new HashSet<>();
	public Department() {

	}

	public int getDept_id() {
		return deptid;
	}

	public void setDept_id(int dept_id) {
		this.deptid = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getDept_total_employee() {
		return dept_total_employee;
	}

	public void setDept_total_employee(int dept_total_employee) {
		this.dept_total_employee = dept_total_employee;
	}

	public Department(int dept_id, String dept_name) {
		super();
		this.deptid = dept_id;
		this.dept_name = dept_name;
		this.dept_total_employee = dept_total_employee;
	}
	
//	@OneToMany
//    @JoinColumn(name = "emp_id")

}
