package com.cg.fitness.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.cg.fitness.Entity.Appointment;
import com.cg.fitness.Entity.Trainer;
import com.cg.fitness.Entity.User;

public class FitnessDaoImpl implements FitnessDao{


	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("fitness-case-study");
    
	/*
	 * Create Appointments and stored in database
	 */
	@Override
	public Integer addAppointment(Appointment appointment) throws PersistenceException {
		EntityManager entityManager = emf.createEntityManager();

		try {
			entityManager.getTransaction().begin();
			entityManager.persist(appointment);
			entityManager.flush();
			entityManager.getTransaction().commit();
			return 1;
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.close();
		}	
	}

	/*
	 * Add trainer details in database
	 */
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
	
	/*
	 * Fetch All Appointments details
	 */
	@Override
	public List<Appointment> viewAppointment() throws PersistenceException {

		EntityManager entityManager=emf.createEntityManager();
		//String jql="select p from Appointment p";
		String jql= "From Appointment p";
		try {			
			entityManager.getTransaction().begin();
			//Query q= entityManager.createQuery(jql);
			TypedQuery< Appointment> query=
					entityManager.createQuery(jql,  Appointment.class);
			List< Appointment> appointmentList=query.getResultList();
			entityManager.getTransaction().commit();			
			return appointmentList;
		}catch(PersistenceException e) {
			entityManager.getTransaction().rollback();		
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}
	}
	
	//Get Appointment details by Id
	@Override
	public Appointment getAppointmentById(Integer appointment_id) throws PersistenceException {

		EntityManager entityManager=emf.createEntityManager();
		try {
			//entityManager.getTransaction().begin();
			Appointment appointment =
					entityManager.find(Appointment.class, appointment_id);			
			//entityManager.getTransaction().commit();
			return appointment;
		}catch(PersistenceException e) {
			//entityManager.getTransaction().rollback();
			throw e;
		}catch(Exception e) {
			throw e;
		}finally {
			entityManager.close();
		}	
	}
	
	/*
	 * Delete Appointment 
	 */
	@Override
	public Integer deleteAppointment(Integer appointment_id) throws PersistenceException {

		EntityManager entityManager=emf.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Appointment appointment= 
					entityManager.find(Appointment.class, appointment_id);
			entityManager.remove(appointment);
			//entityManager.flush();
			entityManager.getTransaction().commit();	
			return appointment.getAppointment_id();
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
	 * Get Trainer Details By Id
	 */
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


