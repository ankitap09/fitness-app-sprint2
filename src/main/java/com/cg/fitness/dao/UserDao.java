package com.cg.fitness.dao;

import javax.persistence.PersistenceException;

import com.cg.fitness.Entity.User;

public interface UserDao {
	public Integer addUser(User user) throws PersistenceException;
	public User getUserById(Integer user_id) throws  PersistenceException;
}
