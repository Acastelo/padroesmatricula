package com.j7ss.core;

import java.io.Serializable;
import java.util.List;

import com.j7ss.core.DAOException;
import com.j7ss.core.IGenericEntity;
import com.j7ss.core.Messages;

public abstract class BasicView<T extends IGenericEntity<T>> implements Serializable{

	private static final long serialVersionUID = 1L;

	protected T entity;
	protected List<T> entitys;

	public boolean form = false;
	
	public void grid(){
		entity = null;
		entitys = null;
		form = false;
	}
	
	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public List<T> getEntitys() {
		return entitys;
	}

	public void form(){
		form = true;
	}
	
	public void save(){
		try {
			entity.save();
			onSave();
		} catch (DAOException e) {
			onError(e);
		}
		grid();
	}
	
	public void remove(T entity){
		try {
			if (entity.remove()){
				onRemove(entity);
			}
		} catch (DAOException e) {
			onError(e);
		}
		grid();
	}
	
	
	public void onSave(){
		Messages.showGrowlInfo("Entidade", "Entidade salva com sucesso!");
	}
	
	public void onRemove(T entity){
		Messages.showGrowlInfo("Entidade", "Entidade removido com sucesso!");
	}
	
	public void onError(Exception e){
		Messages.showGrowlErro("Entidade", e.getMessage());
	}
}
