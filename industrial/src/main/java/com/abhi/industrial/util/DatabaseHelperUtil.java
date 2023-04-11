package com.abhi.industrial.util;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManager;

@Component
public class DatabaseHelperUtil {
	
	@Autowired
	EntityManager entityManager;
	
	public Session getSession() {
		return entityManager.unwrap(org.hibernate.Session.class);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
