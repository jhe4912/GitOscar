package com.example.simplerestapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import com.example.simplerestapi.models.SampleResponse;

@RestController
public class WebController {
	
	int id = -1;
	
	@RequestMapping("/sample")
	public SampleResponse Sample(@RequestParam(value = "name", defaultValue = "Robot") String name) {
		SampleResponse response = new SampleResponse();
		response.setId(id+1);
		response.setMessage("Your name is " + name);
		return response;
	}
	
}