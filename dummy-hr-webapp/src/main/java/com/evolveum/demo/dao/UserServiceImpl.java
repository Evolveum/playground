package com.evolveum.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.evolveum.demo.model.UserJpa;

@Service
public class UserServiceImpl implements UserServiceJpa {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public List<UserJpa> listUsers() {
		return userDao.listAllUsers();
	}

	@Transactional
	public void registerUser(UserJpa user) {
		userDao.registerUser(user);
	}

	@Override
	@Transactional(readOnly = true)
	public UserJpa getUser(Integer id) {
		return userDao.getUser(id);
	}

	@Override
	@Transactional
	public void modifyUser(UserJpa user) {
		userDao.modifyUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(UserJpa user) {
		userDao.deleteUser(user);
	}
}
