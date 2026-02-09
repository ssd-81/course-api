package com.company.course_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CourseApiApplication {

	public static void main(String[] args) {

        // what is going on here?
        ApplicationContext apc = SpringApplication.run(CourseApiApplication.class, args);
//        for(String s : apc.getBeanDefinitionNames()) {
//            System.out.println(s);
//        }
	}

}
