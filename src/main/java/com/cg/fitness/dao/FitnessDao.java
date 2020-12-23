package com.cg.fitness.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.PersistenceException;

import com.cg.fitness.Entity.Appointment;
import com.cg.fitness.Entity.Trainer;
import com.cg.fitness.Entity.User;


public interface FitnessDao {

	//Appointemnt 
	public Integer addAppointment(Appointment appointment) throws PersistenceException; 
	public List<Appointment> viewAppointment() throws PersistenceException;
	public Appointment getAppointmentById(Integer appointment_id) throws  PersistenceException;
	public Integer deleteAppointment(Integer appointment_id) throws PersistenceException;

	//User
	public Integer addUser(User user) throws PersistenceException;
	public User getUserById(Integer user_id) throws  PersistenceException;

	//Trainer
	public Integer addTrainer(Trainer trainer) throws PersistenceException;
	public Trainer getTrainerById(Integer trainer_id) throws  PersistenceException;


}

