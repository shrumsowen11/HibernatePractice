package com.banepali.dataBase.dao;

import java.sql.Time;
import java.util.List;

import com.banepali.dataBase.dao.entity.EmployeeEntity;

public interface EmployeeDao {

	void save(EmployeeEntity entity);

    List<EmployeeEntity> findAll();
	List<String> findAllUserId();

    
    EmployeeEntity employeeById(int eID);
    EmployeeEntity employeeByEmail(String email);
    EmployeeEntity employeeByUserId(String userId);
	EmployeeEntity optionalEmployeeByEmail(String email);

    EmployeeEntity employeeLogin(String email, String password);
    
    void update(EmployeeEntity entity);
	String updatePassword(String email, String password);
	String updatePassword(String password);
	void updateEmployeeActiveStatus(String userId);
	void updateEmployee(EmployeeEntity employeeEntity);

    
    
    void deleteById(int eID);
	void deleteByEmail(String email);

	int getIncrementedEId();

	Time getStartTime();
	Time getEndTime();

	byte[] findImageById(int sid);

	String updatePassword(EmployeeEntity employeeEntity, String password);


	

	

	




	

	



}
