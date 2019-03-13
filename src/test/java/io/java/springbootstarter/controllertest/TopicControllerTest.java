package io.java.springbootstarter.controllertest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import io.java.springbootstarter.topic.Topic;
import io.java.springbootstarter.topic.TopicController;
import io.java.springbootstarter.topic.TopicService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TopicController.class)
public class TopicControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TopicService service;

	@Before
	public void setUp() {
		int id=1;
		String name="java";
		String description="java description";
		Topic topic=new Topic(id,name,description);
	
		List<Topic> topicList=new ArrayList<>();
		topicList.add(topic);
		Mockito.when(service.getAllTopics()).thenReturn(topicList);
		Mockito.when(service.getTopic(id)).thenReturn(topic);
	}

	@Test
	public void getTopic_byId_topic() throws Exception {
		
	}
	
	@Test
	public void getAllTopics_listOfTopics() throws Exception {

		mockMvc.perform(get("/topics")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", Matchers.hasSize(1)))
				.andExpect(jsonPath("$[0].id",is(1)));
		// .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(2)));
	}
	
	@Test
	public void addTopic_statusOk() throws Exception {
		
		String json = new JSONObject()
                .put("id", "3")
                .put("name", "python")
                .put("description", "python description").toString();
		
		mockMvc.perform(post("/topics").
		contentType(MediaType.APPLICATION_JSON_UTF8)
		.content(json))
		.andExpect(status().isOk());	     
	}
}
