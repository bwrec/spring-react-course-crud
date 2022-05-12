package com.springrest.springrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CoursesDao;
import com.springrest.springrest.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {
	
//	List<Courses> list;
	@Autowired
	private CoursesDao coursesDao;
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Courses(121,"Java Course 1", "Beginner course for Java"));
//		list.add(new Courses(122,"Java Course 2", "Intermediate course for Java"));
//		list.add(new Courses(123,"Java Course 3", "Advanced course for Java"));
//		list.add(new Courses(124,"Java Course 4", "Professional course for Java"));
		
	}

	@Override
	public List<Courses> getCourses() {
		// TODO Auto-generated method stub
//		return list;
		
		return coursesDao.findAll();
	}

	@Override
	public Courses getCourse(long courseId) {
		// TODO Auto-generated method stub
//		Courses c = null;
//		for (Courses courses : list) {
//			if(courses.getId()==courseId) {
//				c=courses;
//				break;
//			}
//		}
//		return c;
		
		return coursesDao.getOne(courseId);
	}

	@Override
	public Courses addCourse(Courses course) {
		// TODO Auto-generated method stub
//		list.add(course);
//		return course;
		
		coursesDao.save(course);
		return course;
	}

	@Override
	public Courses updateCourse(Courses course) {
		// TODO Auto-generated method stub
//		boolean added=false;
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getId()==course.getId()) {
//				list.add(i, course);
//				added=true;
//				break;
//			}
//		}
//		if(added==false) {
//			list.add(course);
//		}
//		return course;
		
//		list.forEach(e->{
//			if(e.getId()==course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
//		return course;
		
		coursesDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		// TODO Auto-generated method stub
//		Courses c = null;
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i).getId()==courseId) {
//				c = list.get(i);
//				list.remove(i);
//				break;
//			}
//		}
//		return c;
		
//		list=this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
		Courses c = coursesDao.getOne(courseId);
		coursesDao.delete(c);
	}

}
