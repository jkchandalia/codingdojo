package com.codingdojo.dojosurvey;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class Survey {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	

	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String submit(@RequestParam(value="name") String name,
						@RequestParam(value="dojo") String dojo,
						@RequestParam(value="lang") String lang,
						@RequestParam(value="comment") String comment,
						HttpSession session) {
		
		session.setAttribute("name", name);
		session.setAttribute("dojo", dojo);
		session.setAttribute("lang", lang);
		session.setAttribute("comment", comment);
    	return "redirect:/result";
        }  
	

	@RequestMapping("/result")
	public String result() {
		return "result.jsp";
	}
}
