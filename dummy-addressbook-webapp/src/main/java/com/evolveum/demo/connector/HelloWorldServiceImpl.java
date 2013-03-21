package com.evolveum.demo.connector;

import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService{

	  public String sayHello() {
		    return "Hello World from Spring";
	  }

}
