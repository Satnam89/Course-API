package io.java.springbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@SpringBootApplication tells the spring boot
 *  that this is the starter point of the application
 */
public class CourseApiApp {

	public static void main(String[] args) {
		
		/*
		 * SpringApplication does
		 * 1)default configration
		 * 2)starts spring application context(Spring container for the spring beans)
		 * 3)performs class path scan (scan for the annotation eg @service,@controller)
		 * 4) starts Tomcat server
		 */
		SpringApplication.run(CourseApiApp.class, args);
		

	}

}
