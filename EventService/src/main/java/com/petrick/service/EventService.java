package com.petrick.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petrick.persistence.Event;
import com.petrick.persistence.dao.IEventDAO;

@Service
@Transactional
public class EventService implements IEventService {
	
	@Autowired
	private IEventDAO dao;
	
	public IEventDAO getDao() {
        return dao;
    }
	
	@Transactional(readOnly = true)
    public Event findOne(final long id) {
        return getDao().findOne(id);
    }

    @Transactional(readOnly = true)
    public List<Event> findAll() {
        return getDao().findAll();
    }
	
}
