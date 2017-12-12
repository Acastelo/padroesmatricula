package com.j7ss.core;

import java.io.Serializable;

public interface IGenericEntity<T> extends Serializable{

	boolean isNew();
	
	T save() throws DAOException;
	
	boolean remove() throws DAOException;
}
