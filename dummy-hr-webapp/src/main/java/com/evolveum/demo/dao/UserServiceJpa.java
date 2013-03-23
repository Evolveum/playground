package com.evolveum.demo.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.evolveum.demo.model.UserJpa;

public interface UserServiceJpa {

	@Transactional
	public abstract List<UserJpa> listUsers();
	
	@Transactional
	public abstract void registerUser(UserJpa user);
	
	public abstract UserJpa getUser(Integer id);

	@Transactional
	public abstract void modifyUser(UserJpa user);
	
	@Transactional
	public abstract void deleteUser(UserJpa user);
}