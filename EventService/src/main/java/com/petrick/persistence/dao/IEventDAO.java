package com.petrick.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.petrick.persistence.Event;

public interface IEventDAO  extends JpaRepository<Event, Long>, JpaSpecificationExecutor<Event>{
	// No method signatures needed here, inherited from JpaRepository
}