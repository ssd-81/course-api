package com.company.course_api.service;

import com.company.course_api.controller.Topic;
import com.company.course_api.respository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    List<Topic> topics = new ArrayList<>(
            Arrays.asList(
                    new Topic("1", "ursula", "author"),
                    new Topic("2", "ging", "hunter")
            )
    );


//    List<Topic> topics = new List<>(
//            Arrays.asList(
//                    new Topic("1", "ursula", "author"),
//                    new Topic("2", "ging", "hunter")
//            )
//    );


    // interface -> converted to abstract class by spring boot
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
         return topicRepository.findAll();
    }

    @RequestMapping("/topic/{id}")
    public Topic getTopicById(@PathVariable String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    @RequestMapping(value = "/topics", method=RequestMethod.POST)
    public void save(@RequestBody Topic topic) {
        topicRepository.save(topic);
    }
}
