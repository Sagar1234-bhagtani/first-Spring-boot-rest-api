package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;
@Service
public class courseserviceimpl implements courseservive {
	
	
	List<Course> list;
	
	public courseserviceimpl() {
		
		list=new ArrayList<>();
		list.add(new Course(145,"Heloo Sagar","nani"));
		list.add(new Course(148,"Heloo Tagar","Lani"));
		
		
	}

	@Override
	public List<Course> getCourses() {
		
		return list;
	}

	@Override
	public Course getCourses(long courseId) {
		Course c=null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
				
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		
		list.forEach(e->{
			
			if(e.getId()==course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		}
		
				
				);
		return course;
	}

	@Override
	public void deletecourse(long courseId) {
		list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
	
	}


	

	
	
}
