package com.codingdojo.controllerspractice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
public class DojoController {
	@RequestMapping("/{dojo}")
    public String dojo(@PathVariable("dojo") String dojo)
    {String output="hi";
      if (dojo.equals("dojo")) {
    	 output= "The dojo is awesome!";
      }
    else if (dojo.equals("burbank-dojo")) {
    	  output = "Burbank dojo";
      }
      else if (dojo.equals("san-jose")) {
    	  output = "San Jose dojo";
      }
	  return output;
    }
	
}
