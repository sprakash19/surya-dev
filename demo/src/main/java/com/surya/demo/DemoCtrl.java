package com.surya.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoCtrl {
	
@RequestMapping("/getUrl")	
public String hello() {
	
	return "hello";
}
}
