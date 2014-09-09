package com.petrick.persistence;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy/MM/dd") 
    private Calendar eventDate;
    
    @Column(nullable = false)
    private String location;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String eventWebSite;

    public Event() {
        super();
    }

    public Event(final String name) {
        super();
        this.name = name;
    }
    
    public Event(final String name, final Calendar eventDate) {
        super();
        this.name = name;
        this.eventDate = eventDate;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    
    public Calendar getEventDate() {
		return eventDate;
	}

	public void setEventDate(Calendar eventDate) {
		this.eventDate = eventDate;
	}
	
	public String getEventDateString(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("sdf.format(this.eventDate.getTime()) " + sdf.format(this.eventDate.getTime()));
		return sdf.format(this.eventDate.getTime());
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getEventWebSite() {
		return eventWebSite;
	}

	public void setEventWebSite(String eventWebSite) {
		this.eventWebSite = eventWebSite;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Event other = (Event) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Event [name=").append(name).append("]");
        return builder.toString();
    }
}
