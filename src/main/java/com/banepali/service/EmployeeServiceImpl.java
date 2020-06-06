package com.banepali.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.banepali.controller.dto.EmployeeDTO;
import com.banepali.dataBase.dao.EmployeeDao;
import com.banepali.dataBase.dao.ORMEmployeeDaoImpl;
import com.banepali.dataBase.dao.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	@Qualifier("ORMEmployeeDaoImpl")
	private EmployeeDao employeeDao;

	@Override
	public void save(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDTO, employeeEntity);
		employeeDao.save(employeeEntity);
	}

	@Override
	public List<EmployeeDTO> findAll() {
		List<EmployeeEntity> list = employeeDao.findAll();
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		for (EmployeeEntity employeeEntity : list) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
			employeeDTOs.add(employeeDTO);
		}
		return employeeDTOs;
	}

	@Override
	public List<String> findAllUserId() {
		List<String> userIds = new ArrayList<String>();
		userIds = employeeDao.findAllUserId();
		return userIds;
	}

	@Override
	public void deleteById(int eID) {
		employeeDao.deleteById(eID);

	}

	@Override
	public void deleteByEmail(String email) {
		employeeDao.deleteByEmail(email);
	}

	@Override
	public EmployeeDTO employeeById(int eID) {

		EmployeeEntity employeeEntity = employeeDao.employeeById(eID);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employeeEntity, employeeDTO);
		return employeeDTO;
	}

	@Override
	public EmployeeDTO employeeByUserId(String userId) {
		EmployeeEntity employeeEntity = employeeDao.employeeByUserId(userId);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employeeEntity, employeeDTO);
		return employeeDTO;
	}

	@Override
	public EmployeeDTO employeeByEmail(String email) {
		EmployeeEntity employeeEntity = employeeDao.employeeByEmail(email);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employeeEntity, employeeDTO);
		return employeeDTO;

	}

	@Override
	public Optional<EmployeeDTO> optionalEmployeeByEmail(String email) {
		EmployeeEntity employeeEntity = employeeDao.optionalEmployeeByEmail(email);
		EmployeeDTO employeeDTO = new EmployeeDTO();
		BeanUtils.copyProperties(employeeEntity, employeeDTO);
		return Optional.ofNullable(employeeDTO);
	}

	@Override
	public EmployeeDTO employeeLogin(String email, String password) {
		EmployeeEntity optionalEmplEntity = employeeDao.employeeLogin(email, password);
		EmployeeDTO employeeDTO = null;
		//if (optionalEmplEntity!= null) { 
			employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(optionalEmplEntity, employeeDTO);
		//}
		return employeeDTO;

	}

	/*
	 * @Override public EmployeeDTO employeeLogin(String email, String password) {
	 * EmployeeEntity emplEntity = employeeDao.employeeLogin(email,password);
	 * EmployeeDTO employeeDTO = null; if(emplEntity != null) { employeeDTO = new
	 * EmployeeDTO(); BeanUtils.copyProperties(emplEntity, employeeDTO); } return
	 * employeeDTO;
	 * 
	 * }
	 */

	
	@Override
	public byte[] findImageById(int sid) {
		return employeeDao.findImageById(sid);
	}
	
	
	@Override
	public void update(EmployeeDTO employeeDTO) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		BeanUtils.copyProperties(employeeDTO, employeeEntity);
		employeeDao.update(employeeEntity);
	}

	@Override
	public Time getStartTime() {
		Time startTime = employeeDao.getStartTime();
		return startTime;
	}

	@Override
	public Time getEndTime() {
		Time endTime = employeeDao.getEndTime();
		return endTime;
	}

	@Override
	public int getIncrementedEId() {
		return employeeDao.getIncrementedEId();
	}

	// To Be Done: public String/void updateEmployeeByUserId(EmployeeEntity
	// employeeEntity)

	@Override
	public String updatePassword(String email, String password) {
		return employeeDao.updatePassword(email, password);
		// change the return type to String, pass a message saying that the password is
		// updated
	}

	@Override
	public void updateEmployeeActiveStatus(String userId) {
		employeeDao.updateEmployeeActiveStatus(userId);

	}

}
