package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.SampleValue;

@Controller
public class SampleController {
	
	@GetMapping("/")
	public String test(Model model) {
		
		model.addAttribute("samplevalue", "Hello World");
		return "sampleindex";
	}
	
	@PostMapping("/test")
	public String testPost(@Validated 
			@ModelAttribute("samplevalue") SampleValue samplevalue,
			BindingResult result) {
		return "sampleindex";
	}

}
