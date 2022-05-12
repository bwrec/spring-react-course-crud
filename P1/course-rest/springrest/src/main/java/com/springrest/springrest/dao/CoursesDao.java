package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entities.Courses;

public interface CoursesDao extends JpaRepository<Courses, Long> { 

	//JpaRepository<Type of entity to perform operation on, data type of primary key>
}
