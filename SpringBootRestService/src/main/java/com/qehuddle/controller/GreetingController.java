package com.qehuddle.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	@Autowired
	Greeting greeting;
	private static final Logger logger=LoggerFactory.getLogger(GreetingController.class);
	AtomicLong counter=new AtomicLong();
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name")String name)
	{
		greeting.setId(counter.incrementAndGet());
		greeting.setContent("Greeting from "+name);
	return greeting;	
		
	}

}
