package com.petrick.web;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.View;

import com.petrick.persistence.Event;
import com.petrick.persistence.dao.IEventDAO;
import com.petrick.spring.WebConfiguration;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {
						// MVC application context to be tested
						WebConfiguration.class, 
})
@RunWith(SpringJUnit4ClassRunner.class)
public class AddEventControllerUnitTest {
	
	@Autowired private WebApplicationContext ctx;
	
	protected MockMvc mockMvc;
	
	@InjectMocks
	AddEventController controller;

    @Mock
    IEventDAO mockEventDao;
    
    @Mock
    View mockView;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        //mockMvc = MockMvcBuilders.standaloneSetup(controller).build();        
        this.mockMvc = webAppContextSetup(ctx).build();
    }

    @Test
    public void testAddEventSubmit() throws Exception {
       
    	//when(mockEventDao.saveAndFlush(event)).thenReturn(event);
        
    	// Tests the http request/response for calling the add event page via GET
        mockMvc.perform(get("/addevent"))
        // HTTP 200 returned
        .andExpect(status().isOk())
        // Controller forwards to correct view
        .andExpect(view().name("addevent"))
        // Event model attribute is set
        .andExpect(model().attributeExists("event")); 
        
        // Tests the http request/response for submitting the form via GET
        mockMvc.perform(post("/addevent")
        .param("name", "TestEvent")
        .param("eventDate", "2014/09/29")
        .param("location", "Berlin")
        .param("description", "Blabla")
        .param("eventWebSite", "http/www.da.de")
        )
        // HTTP 200 returned
        .andExpect(status().isOk())
        // Controller forwards to correct view
        .andExpect(view().name("events"))
        // Event model attribute is set
        .andExpect(model().attributeExists("event")); 
    }
}
