package com.j7ss.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.j7ss.core.DAOException;
import com.j7ss.core.util.JPAUtil;
import com.j7ss.entity.Usuario;

public class UsuarioDao implements GenericDao<Usuario> {
	public EntityManager entityManager = JPAUtil.getInstancia();

	@Override
	public Usuario save(Usuario instance) throws DAOException {
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
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll(Integer begin, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findByExample(Usuario example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findByExample(Usuario example, Integer begin, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Usuario isntance) {
		// TODO Auto-generated method stub
		
	}

}
