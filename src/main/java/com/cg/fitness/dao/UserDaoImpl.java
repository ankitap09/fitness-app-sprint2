package com.cg.fitness.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.cg.fitness.Entity.User;

public class UserDaoImpl implements UserDao{
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("fitness-case-study");
	/*
	 * Add user details in database
	 */
	@Override
	public Integer addUser(User user) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {			
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.flush();
			entityManager.getTransaction().commit();
			return 1;
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}
	}

	  /*
     * Get User Details By Id
     */
	@Override
	public User getUserById(Integer user_id) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			//entityManager.getTransaction().begin();
			User user =
					entityManager.find(User.class, user_id);			
			//entityManager.getTransaction().commit();
			return user;
		}catch(PersistenceException e) {
			//entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}
	}
}
