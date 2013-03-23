package com.evolveum.demo.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.NamedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evolveum.demo.model.UserJpa;

@Repository
public class UserDaoImpl implements UserDao {

	 @Autowired
	 @Resource(name="sessionFactory")
	 private SessionFactory sessionFactory;
	 

	@Override
	public List<UserJpa> listAllUsers(){
		 List<UserJpa> users = sessionFactory.getCurrentSession().createQuery("from UserJpa").list();
		 return users;
	 }

	@Override
	public void modifyUser(UserJpa user){
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	 }
	 

	@Override
	public void registerUser(UserJpa user){
		 sessionFactory.getCurrentSession().save(user);
	 }
	 
	@Override
	public void deleteUser(UserJpa user){
		sessionFactory.getCurrentSession().delete(user);
	 }
	
	public UserJpa getUser(Integer id){
		return (UserJpa) sessionFactory.getCurrentSession().get(UserJpa.class, id);
	}

}
