package com.banepali.dataBase.dao.entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // this class object will/can be sent to be saved in the database
@Table(name = "hibernate_employee_tbl")
/*
 * --> Hibernate has this features, it can automatically make the table in the
 * database for you using the above "@Table" from persistence --> We have to
 * assign a primary key in here --> you can write in the beginning of the
 * variable declaration or in the "getter"
 * 
 * --> *********** If your entity has "photo" with LongBlob then mention,
 * otherwise it will take the "@Column" == "TinyBlob" *****
 * 
 * 
 */public class EmployeeEntity {
	private int eID;
	private String userId;
	private String password;
	private String name;
	private String email;
	private Date date;
	private long mobile;
	private double salary;
	private long ssn;
	private Timestamp createDate;
	private Timestamp updateDate;
	String role = "Customer";
	private Time startTime;
	private Time endTime;
	private String active;
	private byte[] bPhoto;

	public EmployeeEntity() {
	}

	public EmployeeEntity(int eID, String userId, String password, String name, String email, Date date, long mobile,
			double salary, long ssn, Timestamp createDate, Timestamp updateDate, String role, Time startTime,
			Time endTime, String active, byte[] bPhoto) {
		super();
		this.eID = eID;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.date = date;
		this.mobile = mobile;
		this.salary = salary;
		this.ssn = ssn;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.role = role;
		this.startTime = startTime;
		this.endTime = endTime;
		this.active = active;
		this.bPhoto = bPhoto;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Column(columnDefinition = "varchar(30) default 'Customer'")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(length = 30) // otherwise, it will take by default 255
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // in order to make it the primary key
	public int geteID() {
		return eID;
	}

	public void seteID(int eID) {
		this.eID = eID;
	}

	@Column(length = 100) // otherwise, it will take by default 255
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(length = 100) // otherwise, it will take by default 255
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Column(columnDefinition = "longblob")
	public byte[] getbPhoto() {
		return bPhoto;
	}

	public void setbPhoto(byte[] bPhoto) {
		this.bPhoto = bPhoto;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [eID=" + eID + ", userId=" + userId + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", date=" + date + ", mobile=" + mobile + ", salary=" + salary + ", ssn=" + ssn
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", role=" + role + ", startTime="
				+ startTime + ", endTime=" + endTime + ", active=" + active + "]";
	}

}