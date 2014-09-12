package com.evolveum.demo.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evolveum.demo.model.UserJpa;

@Repository
public class UserDaoImpl implements UserDao {

	private EntityManager entityManagerFactory;

	public EntityManager getEntityManagerFactory() {
		return entityManagerFactory;
	}

	@PersistenceContext
	public void setEntityManagerFactory(EntityManager entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<UserJpa> listAllUsers() {
		Query q = (Query) entityManagerFactory
				.createQuery("select u from UserJpa u");
		List<UserJpa> users = (List<UserJpa>) q.getResultList();

		return users;
	}

	@Override
	public void modifyUser(UserJpa user) {
		entityManagerFactory.merge(user);
	}

	@Override
	public void registerUser(UserJpa user) {
		entityManagerFactory.persist(user);
	}

	@Override
	public void deleteUser(UserJpa user) {
		UserJpa u = entityManagerFactory.merge(user);
		entityManagerFactory.remove(u);
	}

	public UserJpa getUser(Integer id) {
		return (UserJpa) entityManagerFactory.createNamedQuery("findUserById")
				.setParameter("id", id).getResultList().get(0);
	}
}
