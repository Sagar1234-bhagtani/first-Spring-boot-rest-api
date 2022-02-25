package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.course_dao;
import com.springrest.springrest.entities.Course;
@Service
public class courseserviceimpl implements courseservive {

@Autowired
private course_dao Course_dao;	
//	List<Course> list;
	
	public courseserviceimpl() {
		
//		list=new ArrayList<>();
//		list.add(new Course(145,"Heloo Sagar","nani"));
//		list.add(new Course(148,"Heloo Tagar","Lani"));
//		
		
	}

	@Override
	public List<Course> getCourses() {
		
		return Course_dao.findAll();
	}

	@Override
	public Course getCourses(Long courseId) {
//		Course c=null;
//		for(Course course:list) {
//			if(course.getId()==courseId) {
//				c=course; 
//				break;
//				
//			}
//		}
		return Course_dao.getOne(courseId);
	}

	@Override
	public Course addCourse(Course course) {
		//list.add(course);
		
		Course_dao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		
//		list.forEach(e->{
//			
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		}
		
				
	//			);
		
		Course_dao.save(course);
		return course;
	}

	@Override
	public void deletecourse(Long courseId) {
//		list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
	     
		
		Course entity=Course_dao.getOne(courseId);
		Course_dao.delete(entity);
	}


	

	
	
}
