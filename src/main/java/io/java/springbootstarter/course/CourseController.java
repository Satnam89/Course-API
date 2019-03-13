package io.java.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.java.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	//dependency injection of Courseservice
	@Autowired
	CourseService Courseservice;
	
	@RequestMapping(method=RequestMethod.GET,value="/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable int topicId) {
		//System.out.println("Inside getAllCourses");
		return Courseservice.getAllCourses(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable int courseId){
		//System.out.println("Inside getCourse");
		return Courseservice.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable int topicId){
		System.out.println("Inside addCourse");
		course.setTopic(new Topic(topicId, "", ""));
		Courseservice.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{courseId}")
	public void updateCourse(@RequestBody Course course,@PathVariable int topicId,@PathVariable int courseId){
		course.setTopic(new Topic(topicId,"",""));
		Courseservice.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{courseId}")
	public void deleteCourse(@PathVariable int courseId){
			Courseservice.deleteCourse(courseId);
	}
	
	
}
