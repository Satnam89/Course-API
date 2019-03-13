package io.java.springbootstarter.repositorytest;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.java.springbootstarter.course.Course;
import io.java.springbootstarter.course.CourseRepository;
import io.java.springbootstarter.topic.Topic;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CourseRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;
	
	@Autowired
	private CourseRepository repository;

	@Before
	public void setup(){
//		Course course=new Course(1, "python", "python description", 2);
//		entityManager.persist(course);
//	    entityManager.flush();
	}
	@Test
	public void testTopicRepository() {
		Topic topic = new Topic();
		topic.setId(1);
		Course course=new Course();
		course.setId(2);
		course.setName("python");
		course.setDescription("python description");
		course.setTopic(topic);
		entityManager.persist(topic);
		entityManager.persist(course);
	    entityManager.flush();
		List<Course> courseList=repository.findByTopicId(course.getTopic().getId());
		assertThat(1, is(courseList.size()));
	}
	
}
