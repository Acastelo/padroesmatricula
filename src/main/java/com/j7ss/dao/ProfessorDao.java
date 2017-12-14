package com.j7ss.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.j7ss.core.DAOException;
import com.j7ss.core.util.JPAUtil;
import com.j7ss.entity.Professor;

public class ProfessorDao implements GenericDao<Professor>{
	
	private EntityManager entityManager = JPAUtil.getInstancia();
	
	@Override
	public Professor save(Professor instance) throws DAOException {
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
	public Professor findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> findAll(Integer begin, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> findByExample(Professor example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> findByExample(Professor example, Integer begin, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Professor isntance) {
		// TODO Auto-generated method stub
		
	}
	
}
