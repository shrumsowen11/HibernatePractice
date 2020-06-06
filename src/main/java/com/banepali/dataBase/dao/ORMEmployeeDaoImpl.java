package com.banepali.dataBase.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.banepali.dataBase.dao.entity.EmployeeEntity;

@Repository("ORMEmployeeDaoImpl")
@Transactional // for the various query transaction into the database
public abstract class ORMEmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	// ***************************** DIFFERENT **************************\\
	public Session getSession() {
		return sessionFactory.openSession(); //write once, Session opened everywhere
		//return sessionFactory.getCurrentSession();

	}
	// ***************************** DIFFERENT **************************\\

	@Override
	public void save(EmployeeEntity entity) {
		getSession().save(entity);
	}

	@Override
	public List<EmployeeEntity> findAll() {
		List<EmployeeEntity> employeeEntities = getSession().createQuery("from EmployeeEntity").getResultList();
		return employeeEntities;
	}

	@Override
	public List<String> findAllUserId() {
		List<String> userIds = getSession().createQuery("from EmployeeEntity").getResultList();

		return userIds;
	}

	@Override
	public void deleteById(int eID) {
		Session session = getSession(); // for deletion, we have to load the session first
		EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, eID);
		session.delete(employeeEntity);
	}

	@Override
	public void deleteByEmail(String email) {
		Session session = getSession(); // for deletion, we have to load the session first
		EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, email);
		session.delete(employeeEntity);

	}

	@Override
	public EmployeeEntity employeeById(int eID) {
		EmployeeEntity employeeEntities = getSession().get(EmployeeEntity.class, eID);
		return employeeEntities;
	}

	@Override
	public EmployeeEntity employeeByUserId(String userId) {
		EmployeeEntity employeeEntities = getSession().get(EmployeeEntity.class, userId);

		return employeeEntities;
	}

	@Override
	public EmployeeEntity employeeByEmail(String email) {
		EmployeeEntity employeeEntities = getSession().get(EmployeeEntity.class, email);

		return employeeEntities;
	}

	@Override
	public EmployeeEntity optionalEmployeeByEmail(String email) {
		EmployeeEntity employeeEntities = getSession().get(EmployeeEntity.class, email);

		return employeeEntities;
	}

	@Override
	public EmployeeEntity employeeLogin(String email, String password) {
		TypedQuery<EmployeeEntity> query = getSession().createQuery(
				"from EmployeeEntity employeeEntity where employeeEntity.email=:pemail and employeeEntity.password=:ppassword"); // HQL
		// here, "pemail" and "ppassword" are the placeholders
		query.setParameter("pusername", email);
		query.setParameter("ppassword", password);

		// As we do not guarantee the incoming emploeeeEntity is the actual Employee or
		// a null value,
		// we need to check.
		// --> checking if the incoming employeeEntity is null or some actual values
		// --> this actually needs to be done in the "ServiceImpl"

		EmployeeEntity loginEntity = null;
		try {
			loginEntity = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginEntity;
	}

	@Override
	public byte[] findImageById(int eid) {
		EmployeeEntity employeeEntities = getSession().get(EmployeeEntity.class, eid);
		return employeeEntities.getbPhoto();
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
		getSession().update(entity);
	}
	/*
	 * @Override public Time getStartTime() { Time startTime = (Time)
	 * jdbcTemplate.queryForObject(SQLQueries.SELECT_STARTTIME, Time.class); return
	 * startTime; }
	 * 
	 * @Override public Time getEndTime() { Time endTime = (Time)
	 * jdbcTemplate.queryForObject(SQLQueries.SELECT_ENDTIME, Time.class); return
	 * endTime; }
	 */

	// To Be Done: public String/void updateEmployeeByUserId(EmployeeEntity
	// employeeEntity)

	@Override
	public String updatePassword( String password) {
		int rowCount = 0;
		getSession().update(password);
		return rowCount > 0 ? "Update Successful" : "Not updated yet. ";

	}

	/*
	 * @Override public void updateEmployeeActiveStatus(String userId) {
	 * 
	 * String status = employeeByUserId(userId).getActive();
	 * 
	 * System.out.println(status); if (status.equals("YES")) { // the "Active"
	 * status of the employee was "YES"
	 * jdbcTemplate.update(SQLQueries.UPDATE_EMP_ACTIVE_STATUS_OFF, userId);
	 * System.out.println(" \t\t\t\t UPDATE_EMP_ACTIVE_STATUS_OFF  was called"); }
	 * 
	 * else { // the "Active" status of the employee was "NO"
	 * jdbcTemplate.update(SQLQueries.UPDATE_EMP_ACTIVE_STATUS_ON, userId);
	 * jdbcTemplate.update(SQLQueries.UPDATE_REMAIN_EMP_ACTIVE_STATUS_OFF, userId);
	 * } // change the return type to String, pass a message saying that the
	 * password is // updated
	 * 
	 * }
	 */

}
