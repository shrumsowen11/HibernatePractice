package com.banepali.controller.dto;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class EmployeeDTO {
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
	private MultipartFile photo;
	private byte[] bPhoto;
	
	
	public EmployeeDTO() { }

	
	
	


	public EmployeeDTO(int eID, String userId, String password, String name, String email, Date date, long mobile,
			double salary, long ssn, Timestamp createDate, Timestamp updateDate, String role, Time startTime,
			Time endTime, String active, MultipartFile photo, byte[] bPhoto) {
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
		this.photo = photo;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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
    public MultipartFile getPhoto() {
		return photo;
	}


	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}


	public byte[] getbPhoto() {
		return bPhoto;
	}


	public void setbPhoto(byte[] bPhoto) {
		this.bPhoto = bPhoto;
	}

    @Override
	public String toString() {
		return "EmployeeDTO [eID=" + eID + ", userId=" + userId + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", date=" + date + ", mobile=" + mobile + ", salary=" + salary + ", ssn=" + ssn
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", role=" + role + ", startTime="
				+ startTime + ", endTime=" + endTime + ", active=" + active + "]";
	}

}
