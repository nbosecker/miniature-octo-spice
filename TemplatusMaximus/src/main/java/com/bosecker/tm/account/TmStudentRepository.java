package com.bosecker.tm.account;

import java.util.List;

import javax.persistence.*;
import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;

@Repository
@Transactional
public class TmStudentRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void save(TmStudent tmStudent) {
		entityManager.merge(tmStudent);
	}
	
	public List<TmStudent> findAll() {
		try {
			return entityManager.createNamedQuery(TmStudent.FIND_ALL, TmStudent.class)
					.getResultList();
		} catch (PersistenceException e) {
			return null;
		}
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public TmStudent findTmStudentById(Long id) {
		return (TmStudent) entityManager.createQuery(
			    "SELECT tm FROM TmStudent tm WHERE tm.id = :userId")
			    .setParameter("userId", id)
			    .getSingleResult();
	}
}


	

