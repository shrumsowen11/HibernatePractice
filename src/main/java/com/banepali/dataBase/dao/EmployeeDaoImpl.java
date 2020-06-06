package com.banepali.dataBase.dao;

import java.sql.Date;
import java.sql.Time;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.banepali.dataBase.dao.entity.EmployeeEntity;
import com.banepali.dataBase.utils.SQLQueries;

@Repository
public abstract class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	LobHandler lobHandler=new DefaultLobHandler();
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void save(EmployeeEntity entity) {
		// photos in java cannot be passed as it is, so we need to convert the
		// byte form of the photo into the sqlLobValue
        SqlLobValue sqlLobValue=new SqlLobValue(entity.getbPhoto(),lobHandler);
		
		
		Object[] entityData = { entity.getUserId(),entity.getPassword(),entity.getName(),
				entity.getEmail(), new java.sql.Date(entity.getDate().getTime()), entity.getMobile(), 
				entity.getSalary(),entity.getSsn(), entity.getCreateDate(), entity.getUpdateDate(), sqlLobValue};
		jdbcTemplate.update(SQLQueries.INSERT_IN_EMP_TBL, entityData, new int[] {Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,Types.DATE,
				Types.BIGINT,Types.DOUBLE, Types.BIGINT,Types.TIMESTAMP,Types.TIMESTAMP,Types.BLOB});
	}

	@Override
	public List<EmployeeEntity> findAll() {
		List<EmployeeEntity> employeeEntities = new ArrayList<EmployeeEntity>();
		employeeEntities = jdbcTemplate.query(SQLQueries.SELECT_ALL_EMPLOYEES,
				new BeanPropertyRowMapper<>(EmployeeEntity.class));
		return employeeEntities;
	}

	@Override
	public List<String> findAllUserId() {
		List<String> userIds = new ArrayList<String>();
		userIds = jdbcTemplate.queryForList(SQLQueries.SELECT_ALL_USERID, (String.class));
		System.out.println("From MVCPractise/EmployeeDaoImpl "+ userIds);
		return userIds;
	}

	@Override
	public void deleteById(int eID) {
		jdbcTemplate.update(SQLQueries.DELETE_EMP_BY_EID, eID);

	}

	@Override
	public void deleteByEmail(String email) {
		jdbcTemplate.update(SQLQueries.DELETE_EMP_BY_EMAIL, email);
	}

	@Override
	public EmployeeEntity employeeById(int eID) {
		EmployeeEntity employeeEntities =  jdbcTemplate.queryForObject(SQLQueries.SELECT_EMP_BY_EID,
				new Object[] { eID }, new BeanPropertyRowMapper<>(EmployeeEntity.class));
		return employeeEntities;
	}

	@Override
	public EmployeeEntity employeeByUserId(String userId) {
		EmployeeEntity employeeEntities = (EmployeeEntity) jdbcTemplate.queryForObject(SQLQueries.SELECT_EMP_BY_USERID,
				new Object[] { userId }, new BeanPropertyRowMapper<>(EmployeeEntity.class));
		return employeeEntities;
	}

	@Override
	public EmployeeEntity employeeByEmail(String email) {
		EmployeeEntity employeeEntities =  jdbcTemplate.queryForObject(SQLQueries.SELECT_EMP_BY_EMAIL,
				new Object[] { email }, new BeanPropertyRowMapper<>(EmployeeEntity.class));
		return employeeEntities;

	}

	@Override
	public EmployeeEntity optionalEmployeeByEmail(String email) {
		EmployeeEntity employeeEntities = (EmployeeEntity) jdbcTemplate.queryForObject(SQLQueries.SELECT_EMP_BY_EMAIL,
				new Object[] { email }, new BeanPropertyRowMapper<>(EmployeeEntity.class));
		return employeeEntities;
	}

	@Override
	public EmployeeEntity employeeLogin(String email, String password) {
		EmployeeEntity employeeEntities = (EmployeeEntity) jdbcTemplate.queryForObject(SQLQueries.CHECK_LOGIN_USER,
				new Object[] { email, password }, new BeanPropertyRowMapper<>(EmployeeEntity.class));
		return employeeEntities;

	}
	
	@Override
	public byte[]  findImageById(int  eid) {
		byte[] bphoto = jdbcTemplate.queryForObject(SQLQueries.FIND_IMAGE_BY_ID,new Object[] {eid},byte[].class);
		return bphoto;
	}

	/*
	 * @Override public EmployeeEntity employeeLogin(String email, String password)
	 * { List<EmployeeEntity> employeeEntities =
	 * jdbcTemplate.query(SQLQueries.CHECK_LOGIN_USER, new Object[]
	 * {email,password}, new BeanPropertyRowMapper<>(EmployeeEntity.class)); return
	 * employeeEntities.size() == 0 ? null : employeeEntities.get(0);
	 * 
	 * }
	 */

	@Override
	public void update(EmployeeEntity entity) {

		Object[] entityData = { entity.geteID(), entity.getUserId(), entity.getPassword(), entity.getName(),
				entity.getEmail(), new Date(entity.getDate().getTime()), entity.getMobile(), entity.getSalary(),
				entity.getSsn(), entity.getCreateDate(), entity.getUpdateDate() };
		jdbcTemplate.update(SQLQueries.UPDATE_EMP_TBL_BY_EID, entityData);
	}

	@Override
	public Time getStartTime() {
		Time startTime = (Time) jdbcTemplate.queryForObject(SQLQueries.SELECT_STARTTIME, Time.class);
		return startTime;
	}

	@Override
	public Time getEndTime() {
		Time endTime = (Time) jdbcTemplate.queryForObject(SQLQueries.SELECT_ENDTIME, Time.class);
		return endTime;
	}

	@Override
	public int getIncrementedEId() {
		int eId = 1;
		eId = (Integer) jdbcTemplate.queryForObject(SQLQueries.SELECT_MAX_EID, int.class);
		return eId++;
	}

	// To Be Done: public String/void updateEmployeeByUserId(EmployeeEntity
	// employeeEntity)

	@Override
	public String updatePassword(String email, String password) {
		int rowCount = 0;
		rowCount = jdbcTemplate.update(SQLQueries.UPDATE_EMP_PASSWORD, new Object[] { email, password });
		return rowCount > 0 ? "Update Successful" : "Not updated yet. ";

	}

	@Override
	public void updateEmployeeActiveStatus(String userId) {

		String status = employeeByUserId(userId).getActive();

		System.out.println(status);
		if (status.equals("YES")) { // the "Active" status of the employee was "YES"
			jdbcTemplate.update(SQLQueries.UPDATE_EMP_ACTIVE_STATUS_OFF, userId);
			System.out.println(" \t\t\t\t UPDATE_EMP_ACTIVE_STATUS_OFF  was called");
		}

		else { // the "Active" status of the employee was "NO"
			jdbcTemplate.update(SQLQueries.UPDATE_EMP_ACTIVE_STATUS_ON, userId);
			jdbcTemplate.update(SQLQueries.UPDATE_REMAIN_EMP_ACTIVE_STATUS_OFF, userId);
		}
		// change the return type to String, pass a message saying that the password is
		// updated

	}

}
