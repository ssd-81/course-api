package com.company.course_api.controller;

import com.company.course_api.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {


//     List<Topic> topics = new ArrayList<>(
//             Arrays.asList(
//                     new Topic("1", "ursula", "author"),
//                     new Topic("2", "ging", "hunter")
//             )
//     );

    // dependency injection | IoC (Inversion of Control)
    @Autowired
    private TopicService topicService;


    @RequestMapping("/")
    public String home() { return "Welcome to course API";}

    @RequestMapping("/hello")
    public String sayHello() {return "Hello world";}

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/topics/{id}")
    public Topic getTopicById(@PathVariable String id) {
        return topicService.getTopicById(id);
    }


    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void save(@RequestBody Topic topic) {
        topicService.save(topic);
    }

}

