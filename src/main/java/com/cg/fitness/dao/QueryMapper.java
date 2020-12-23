package com.cg.fitness.dao;

public interface QueryMapper {

	public static final String VIEW_APPOINTMENTS="select * from Appointment";
	public static final String GET_APPOINTMENT_BY_ID="select * from appointment where appointment_id=?";
	public static final String DELETE_APPOINTMENT="delete from appointment where appointment_id=?";
	public static final String GET_USER_BY_ID="select * from user where user_id=?";
	public static final String GET_TRAINER_BY_ID="select * from user where trainer_id=?";

}
