package com.j7ss.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.j7ss.core.DAOException;
import com.j7ss.core.util.JPAUtil;
import com.j7ss.entity.Aluno;

public class AlunoDao implements GenericDao<Aluno>{
	
	public EntityManager entityManager = JPAUtil.getInstancia();
	
	@Override
	public Aluno save(Aluno instance) throws DAOException{
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(instance);
			entityManager.getTransaction().commit();
			return instance;
		}catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new DAOException(e);
		}finally{
			entityManager.close();
		}
	}

	@Override
	public Aluno findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> findAll(Integer begin, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> findByExample(Aluno example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> findByExample(Aluno example, Integer begin, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Aluno isntance) {
		// TODO Auto-generated method stub
		
	}
	
	

}
