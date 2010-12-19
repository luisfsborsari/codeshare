package app.repositories;

import java.util.List;

import app.models.Sharedcode;

public interface SharedcodeRepository {
	/*
	 * Delete the methods you don't want to expose
	 */
	 
	void create(Sharedcode entity);
	
	void update(Sharedcode entity);
	
	void destroy(Sharedcode entity);
	
	Sharedcode find(Long id);
	
	List<Sharedcode> findAll();

}
