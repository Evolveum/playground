package com.evolveum.demo.dao;

import java.util.List;

import com.evolveum.demo.model.UserJpa;

public interface UserDao {

	public abstract List<UserJpa> listAllUsers();

	public abstract void deleteUser(UserJpa user);

	public abstract void registerUser(UserJpa user);
	
	public abstract UserJpa getUser(Integer id);

	public abstract void modifyUser(UserJpa user);

}