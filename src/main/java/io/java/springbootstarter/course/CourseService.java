package io.java.springbootstarter.course;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository repository;
	
	public List<Course> getAllCourses(int id){
		List<Course> list=new ArrayList<>();
		repository.findByTopicId(id).forEach(x -> list.add(x));
	    return list;
	}
	
	public Course getCourse(int id){
		return repository.findOne(id);
	}

	public void addCourse(Course Course) {
		repository.save(Course);
			//Courses.add(Course);
	}

	public void updateCourse(Course Course) {
		repository.save(Course);
		//Courses.stream().filter(t->t.getId().equals(id)).findFirst().get().setId(id);	
		
	}

	public void deleteCourse(int id) {
		//Courses.removeIf(t -> t.getId().equals(id));
		repository.delete(id);
		
	}

}
