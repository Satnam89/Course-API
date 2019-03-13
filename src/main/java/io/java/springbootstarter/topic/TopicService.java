package io.java.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	TopicRepository repository;
	
	public List<Topic> getAllTopics(){
		List<Topic> list=new ArrayList<>();
	    repository.findAll().forEach(x -> list.add(x));
	    return list;
	}
	
	public Topic getTopic(int id){
		
		return repository.findOne(id);
	}

	public void addTopic(Topic topic) {
		repository.save(topic);
			//topics.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		repository.save(topic);
		//topics.stream().filter(t->t.getId().equals(id)).findFirst().get().setId(id);	
	}

	public void deleteTopic(int id) {
		//topics.removeIf(t -> t.getId().equals(id));
		repository.delete(id);
		
	}

}
