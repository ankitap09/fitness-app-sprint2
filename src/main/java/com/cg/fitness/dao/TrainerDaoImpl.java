package com.cg.fitness.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import com.cg.fitness.Entity.Trainer;

public class TrainerDaoImpl implements TrainerDao{
private EntityManagerFactory emf = Persistence.createEntityManagerFactory("fitness-case-study");
    
	@Override
	public Integer addTrainer(Trainer trainer) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {			
			entityManager.getTransaction().begin();
			entityManager.persist(trainer);
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
	public Trainer getTrainerById(Integer trainer_id) throws PersistenceException {
		EntityManager entityManager=emf.createEntityManager();
		try {
			//entityManager.getTransaction().begin();
			Trainer trainer =
					entityManager.find(Trainer.class, trainer_id);			
			//entityManager.getTransaction().commit();
			return trainer;
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