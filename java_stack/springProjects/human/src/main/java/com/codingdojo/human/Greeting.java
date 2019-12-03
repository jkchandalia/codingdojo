package com.codingdojo.human;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Greeting {
    @RequestMapping("")
    public String index(@RequestParam(value="q", required=false) String queryName) {
        String name;
        if (queryName==null){
        	name = "Human";
        }
        else {
        	name=queryName;
        }
        return "Hello "+ name+"!\r\n\n Welcome to Spring Boot!";
    }

}
