package com.employee.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp_system")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id", length = 4)
	private Integer id;

	@Column(length = 50, nullable = false)
	private String firstname;
	private String lastname;

	private String gender;
	@Column(length = 50)
	private String city;

	private String email;
	@Column(length = 14)
	private Long mobile;

	private String department;
	@Column(length = 6)
	private Long salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstname, String lastname, String gender, String city, String email, Long mobile,
			String department, Long salary) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.city = city;
		this.email = email;
		this.mobile = mobile;
		this.department = department;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender
				+ ", city=" + city + ", email=" + email + ", mobile=" + mobile + ", department=" + department
				+ ", salary=" + salary + "]";
	}

}
