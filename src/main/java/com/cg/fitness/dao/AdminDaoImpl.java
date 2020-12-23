package com.cg.fitness.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.cg.fitness.Entity.Admin;

public class AdminDaoImpl implements AdminDao{
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("fitness-case-study");
    
	@Override
	public Integer addAdmin(Admin admin) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {			
			entityManager.getTransaction().begin();
			entityManager.persist(admin);
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

	
	@Override
	public Admin getAdminById(Integer admin_id) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			//entityManager.getTransaction().begin();
			Admin admin =
					entityManager.find(Admin.class, admin_id);			
			//entityManager.getTransaction().commit();
			return admin;
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
