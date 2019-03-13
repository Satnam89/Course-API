//package io.java.springbootstarter.lesson;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class LessonService {
//	
//	//@Autowired
//	LessonRepository lessonRepository;
//	
//	public List<Lesson> getAllLessons(){
//		List<Lesson> list=new ArrayList<>();
//	    lessonRepository.findAll().forEach(x -> list.add(x));
//	    return list;
//	}
//	
//	public Lesson getLesson(String id){
//		
//		return lessonRepository.findOne(id);
//	}
//
//	public void addLesson(Lesson Lesson) {
//		lessonRepository.save(Lesson);
//			//Lessons.add(Lesson);
//	}
//
//	public void updateLesson(Lesson Lesson, String id) {
//		lessonRepository.save(Lesson);
//		//Lessons.stream().filter(t->t.getId().equals(id)).findFirst().get().setId(id);	
//		
//	}
//
//	public void deleteLesson(String id) {
//		//Lessons.removeIf(t -> t.getId().equals(id));
//		lessonRepository.delete(id);
//		
//	}
//
//}
