package com.springrest.springrest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.service.courseservive;

@RestController
public class MyController {
    @Autowired
	private courseservive CourseService;
	
	@GetMapping("/home")
	public String makeing() {
		return "Hello saGAR";
	}
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return this.CourseService.getCourses();
	}
	
	
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		
   		return this.CourseService.getCourses(Long.parseLong(courseId));
	}
	
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.CourseService.addCourse(course);
	}
	
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.CourseService.updateCourse(course);
	}
	
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deletecourse(@PathVariable String courseId) {
		try {
		this.CourseService.deletecourse(Long.parseLong(courseId));
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		}
		
		
		
		
	}
	

