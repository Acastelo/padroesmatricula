package com.j7ss.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.j7ss.core.DAOException;
import com.j7ss.core.util.JPAUtil;
import com.j7ss.entity.Campus;

public class CampusDao implements GenericDao<Campus>{
	
	public EntityManager entityManager = JPAUtil.getInstancia();
	
	@Override
	public Campus save(Campus instance) throws DAOException {
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
	public Campus findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Campus> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Campus> findAll(Integer begin, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Campus> findByExample(Campus example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Campus> findByExample(Campus example, Integer begin, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Campus isntance) {
		// TODO Auto-generated method stub
		
	}

}
