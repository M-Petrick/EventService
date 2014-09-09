package com.petrick.service;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.petrick.persistence.Event;
import com.petrick.persistence.dao.IEventDAO;


// Mocking out the interactions with the database entirely

@Service
@Transactional
public class EventServiceUnitTest {

    private EventService eventService;

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
    public void findAll() {
    	
    	List<Event> events = new ArrayList<Event>();
        when(eventService.findAll()).thenReturn(events);
        
        List<Event> returned = eventService.findAll();
        
        verify(eventService, times(1)).findAll();
        verifyNoMoreInteractions(eventService);
        
        assertEquals(events, returned);
        
        
//        when(myCrudRepository.findOne(0L)).thenReturn(new TableEntry());
//        myService.removeTableEntry(0l, USERID);
//        verify(myCrudRepository, times(1)).delete(0L);
    }
}
