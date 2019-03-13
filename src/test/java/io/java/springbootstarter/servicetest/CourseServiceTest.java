package io.java.springbootstarter.servicetest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.java.springbootstarter.course.Course;
import io.java.springbootstarter.course.CourseRepository;
import io.java.springbootstarter.course.CourseService;


@RunWith(SpringJUnit4ClassRunner.class)
public class CourseServiceTest {
	@Mock
	private CourseRepository repository;
	
	@InjectMocks
	private CourseService service;
	
	@Before
	public void setup(){
		int courseId=1;
		String name="java";
		String description="java description";
		int topicId=2;
		Course course=new Course(courseId,name,description,topicId);
		List<Course> courseList=new ArrayList<>();
		courseList.add(course);
		Mockito.when(repository.findByTopicId(courseId)).thenReturn(courseList);
		Mockito.when(repository.findOne(courseId)).thenReturn(course);
		Mockito.when(repository.findOne(0)).thenReturn( null);
//		Mockito.when(repository.save(topic)).thenReturn(topic);
	}
	
	@Test
	public void getAllCourses_topicId() {	
		int id=1;
		List<Course> courses=service.getAllCourses(id);
		int expected=courses.size();
		
		assertThat(1,is(expected));
	}
	
	@Test
	public void getCourse_byId_course() {	
		Course course=service.getCourse(1);
		int expected=course.getId();
		assertThat(1,is(expected));
	}
	
	@Test(expected=NullPointerException.class)
	public void getTopic_topicById_exception() {	
		Course course=service.getCourse(0);
		course.getId();
		//assertThat(2,is(course.getId()));
	}
	
	

}
