package com.j7ss.dao;

import java.util.List;

import com.j7ss.core.DAOException;

public interface GenericDao<T> {

	/**
	 * @param instance
	 */
	public T save(T instance) throws DAOException;
	/**
	 * @param id
	 * @return
	 */
	public T findById(Integer id);
	/**
	 * @return
	 */
	public List<T> findAll();
	/**
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<T> findAll(Integer begin, Integer end);
	/**
	 * @param example
	 * @return
	 */
	public List<T> findByExample(T example);
	/**
	 * @param example
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<T> findByExample(T example, Integer begin, Integer end);
	/**
	 * @param isntance
	 */
	public void remove(T isntance);
}
