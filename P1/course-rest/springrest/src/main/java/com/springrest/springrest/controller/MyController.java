package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

@RestController
@CrossOrigin
public class MyController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String homePage() {
		return "Welcome to home page";
	}
	
	//get the courses
	@GetMapping("/courses")
	public  List<Courses> getCourses(){
		return this.courseService.getCourses();
	}
	
	@GetMapping("/courses/{courseId}")
	public Courses getCourse(@RequestParam long courseId) {
		return this.courseService.getCourse(courseId);
	}
	
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses course) {
		return this.courseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Courses updateCourse(@RequestBody Courses course) {
		return this.courseService.updateCourse(course);
	}
	
//	@DeleteMapping("/courses/{courseId}")
//	public Courses deleteCourse(@RequestParam String courseId) {
//		return this.courseService.deleteCourse(Long.parseLong(courseId));
//	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@RequestParam long courseId){
		try {
			this.courseService.deleteCourse(courseId);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
