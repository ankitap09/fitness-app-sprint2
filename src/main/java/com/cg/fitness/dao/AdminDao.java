package com.cg.fitness.dao;

import javax.persistence.PersistenceException;

import com.cg.fitness.Entity.Admin;

public interface AdminDao {
	public Integer addAdmin(Admin admin) throws PersistenceException;
	public Admin getAdminById(Integer admin_id) throws  PersistenceException;
}
