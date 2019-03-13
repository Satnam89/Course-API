package io.java.springbootstarter.servicetest;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import java.util.List;

//import org.hamcrest.core.Is;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import io.java.springbootstarter.topic.Topic;
import io.java.springbootstarter.topic.TopicRepository;
import io.java.springbootstarter.topic.TopicService;

@RunWith(SpringJUnit4ClassRunner.class)
public class TopicServiceTest {
	@Mock
	private TopicRepository repository;
	
	@InjectMocks
	private TopicService service;
	
	@Before
	public void setup(){
		int id=1;
		String name="java";
		String description="java description";
		Topic topic=new Topic(id,name,description);
		List<Topic> topicList=new ArrayList<>();
		topicList.add(topic);
		Mockito.when(repository.findAll()).thenReturn(topicList);
		Mockito.when(repository.findOne(id)).thenReturn(topic);
		Mockito.when(repository.findOne(2)).thenReturn(null);
		Mockito.when(repository.save(topic)).thenReturn(topic);
	}
	
	@Test
	public void getAllTopics_listOfTopics() {	
		List<Topic> topics=service.getAllTopics();
		int expected=topics.size();
		assertThat(1,is(expected));
	}
	
	@Test
	public void getTopic_topicById() {	
		Topic topic=service.getTopic(1);
		int expected=topic.getId();
		assertThat(1,is(expected));
	}
	
	@Test(expected=NullPointerException.class)
	public void getTopic_topicById_exception() {	
		Topic topic=service.getTopic(2);
		assertThat(2,is(topic.getId()));
	}
}
