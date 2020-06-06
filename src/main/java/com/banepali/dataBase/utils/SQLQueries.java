package com.banepali.dataBase.utils;

public interface SQLQueries {

    String INSERT_IN_EMP_TBL = "insert  into employee_tbl ( userid, password, name, email,DOB, mobile, salary, ssn, createdate, updatedate, photo) values (?,?,?,?,?,?,?,?,?,?,?) ";

    String SELECT_ALL_EMPLOYEES = "select  eid ,userid, password, name, email,DOB, mobile, salary, ssn, createdate, updatedate, role, startTime,endTime,active, photo from employee_tbl ";
    String SELECT_ALL_USERID = "select  userid from employee_tbl ";

    String SELECT_EMP_BY_EID = "select eid ,userid, password, name, email,DOB, mobile, salary, ssn, createdate, updatedate, role, startTime, endTime, active, photo from employee_tbl where eid = ?";
    String SELECT_EMP_BY_EMAIL = "select eid ,userid, password, name, email,DOB, mobile, salary, ssn, createdate, updatedate, role, startTime, endTime, active , photo from employee_tbl where email = ?";
    String SELECT_EMP_BY_USERID = "select eid ,userid, password, name, email,DOB, mobile, salary, ssn, createdate, updatedate, role, startTime, endTime, active , photo from employee_tbl where userId = ?";
	public static String FIND_IMAGE_BY_ID = "select photo from employee_tbl where eid=?";

    
    String CHECK_LOGIN_USER = "select eid ,userid, password, name, email,DOB, mobile, salary, ssn, createdate, updatedate, role, startTime, endTime, active from employee_tbl where email = ? and password = ?";
    String SELECT_MAX_EID = "select max(eid) from employee_tbl";
    String SELECT_STARTTIME = "select startTime from time_schedule_tbl where active =\"YES\"";
    String SELECT_ENDTIME = "select endTime from time_schedule_tbl where active =\"YES\"";

    
    String UPDATE_EMP_TBL_BY_EID = "update employee_tbl set eid = ? ,userid = ?,  password = ?,name = ?, email = ?, DOB = ?, mobile = ?, salary = ?, ssn = ?, createdate = ?, updatedate = ? where eid = ?";
    String UPDATE_EMP_PASSWORD = "update employee_tbl set  password = ? where email = ?";
    String UPDATE_EMP_TBL_BY_USERID = "update employee_tbl set eid = ? ,userid = ?,  password = ?,name = ?, email = ?, DOB = ?, mobile = ?, salary = ?, ssn = ?, createdate = ?, updatedate = ? where userid = ?";
    
    
    String UPDATE_EMP_ACTIVE_STATUS_OFF = "UPDATE employee_tbl SET active = \"NO\" where userid =?";
    String UPDATE_EMP_ACTIVE_STATUS_ON = "UPDATE employee_tbl SET active = \"YES\" where userid =?";
    String UPDATE_REMAIN_EMP_ACTIVE_STATUS_OFF = "UPDATE employee_tbl SET active = \"NO\" where userid <> ?";

    

    String DELETE_EMP_BY_EID = "delete from employee_tbl where eid =?";
    String DELETE_EMP_BY_EMAIL = "delete from employee_tbl where email =?";
}




