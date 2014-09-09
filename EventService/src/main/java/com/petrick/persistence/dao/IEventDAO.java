package com.petrick.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.petrick.persistence.Event;

public interface IEventDAO  extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event>{

//	    @Query("SELECT f FROM events f WHERE LOWER(f.name) = LOWER(:name)")
//	    Event retrieveByName(@Param("name") String name);

//	
//	public List<Event> list();
//	
//	public Event get(int id);
//	
//	public void saveOrUpdate(Event event);
//	
//	public void delete(int id);
}