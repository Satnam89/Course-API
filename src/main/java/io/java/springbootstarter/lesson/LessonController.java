//package io.java.springbootstarter.lesson;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import io.java.springbootstarter.course.Course;
//
//@RestController
//public class LessonController {
//
//	//dependency injection of Lessonservice
//	@Autowired
//	LessonService lessonservice;
//	
//	@RequestMapping("/topics/{topicId}/courses/{courseId}/lessons}")
//	public List<Lesson> getAllLessons() {
//		return lessonservice.getAllLessons();
//	}
//	
//	@RequestMapping("/topics/{topicId}/courses/{courseId}/lesson/{lessonId}")
//	public Lesson getLesson(@PathVariable String lessonId){
//		return lessonservice.getLesson(lessonId);
//	}
//	
//	@RequestMapping(method=RequestMethod.POST,value="topics/{topicId}/courses/{courseId}/lessons")
//	public void addLesson(@RequestBody Lesson lesson,@PathVariable String courseId){
//		lesson.setCourse(new Course(courseId, "", "", ""));
//		lessonservice.addLesson(lesson);
//	}
//	
//	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{courseId}/lesson/{lessonId}")
//	public void updateLesson(@RequestBody Lesson Lesson,@PathVariable String id){
//		lessonservice.updateLesson(Lesson,id);
//	}
//	
//	@RequestMapping(method=RequestMethod.DELETE,value="/Lessons/{id}")
//	public void deleteLesson(@PathVariable String id){
//		lessonservice.deleteLesson(id);
//	}
//	
//	
//}
