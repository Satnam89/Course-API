package io.java.springbootstarter.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * Rest controller to controls the incoming client requests
 * @RestController
 */

@RestController
public class HelloController {
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi!";
	}

}
