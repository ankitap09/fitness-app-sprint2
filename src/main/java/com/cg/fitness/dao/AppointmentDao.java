package com.cg.fitness.dao;

import java.util.List;

import javax.persistence.PersistenceException;

import com.cg.fitness.Entity.Appointment;

public interface AppointmentDao {
	//Appointemnt 
		public Integer addAppointment(Appointment appointment) throws PersistenceException; 
		public List<Appointment> viewAppointment() throws PersistenceException;
		public Appointment getAppointmentById(Integer appointment_id) throws  PersistenceException;
		public Integer deleteAppointment(Integer appointment_id) throws PersistenceException;

}
