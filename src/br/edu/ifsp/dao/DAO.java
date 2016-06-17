package br.edu.ifsp.dao;

import java.util.List;

import br.edu.ifsp.database.Database;
import br.edu.ifsp.model.IModel;

public abstract class DAO<E extends IModel> {
	
	protected Database database;
	
	public DAO(Database database) {
		this.database = database;
	}
	
	public abstract boolean insert(E objeto);
	
	public abstract boolean update(E objeto);
	
	public abstract boolean delete(E objeto);
	
	public abstract List<E> listAll();
}
