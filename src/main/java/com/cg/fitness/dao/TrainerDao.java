package com.cg.fitness.dao;

import javax.persistence.PersistenceException;

import com.cg.fitness.Entity.Trainer;

public interface TrainerDao {
	public Integer addTrainer(Trainer trainer) throws PersistenceException;
	public Trainer getTrainerById(Integer trainer_id) throws  PersistenceException;

}
