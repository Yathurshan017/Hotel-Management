package com.model;
import java.util.Date;

public class Employee {
	private int id;
	private String fullName;
	private String address;
	private String nic;
	private String employeeId;
	private String jobPost;
	private Date dateOfBirth;
	private String email;
	private int mobile;

	
	public Employee(String fullName, String address,String nic,String employeeId,String jobPost,Date dateOfBirth,String email, int mobile) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.nic = nic;
		this.employeeId = employeeId;
		this.jobPost = jobPost;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.mobile = mobile;
	}
	public Employee(int id, String fullName, String address,String nic,String employeeId,String jobPost,Date dateOfBirth,String email, int mobile) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.address = address;
		this.nic = nic;
		this.employeeId = employeeId;
		this.jobPost = jobPost;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.mobile = mobile;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getJobPost() {
		return jobPost;
	}
	public void setJobPost(String jobPost) {
		this.jobPost = jobPost;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", address=" + address + ", nic=" + nic
				+ ", employeeId=" + employeeId + ", jobPost=" + jobPost + ", dateOfBirth=" + dateOfBirth + ", email="
				+ email + ", mobile=" + mobile + "]";
	}
	
	
}
