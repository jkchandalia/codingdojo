package com.codingdojo.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication

@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	// 1. Annotation
    @RequestMapping("/")
    // 3. Method that maps to the request route above
    public String hello() { // 3
            return "Welcome, client! How are you?";
    }
 // 1. Annotation
    @RequestMapping("/random")
    // 3. Method that maps to the request route above
    public String fine() { // 3
            return "SpringBoot seems fine so far!";
    }

}








// 2. Importing dependencies

