package com.codingdojo.code;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Code {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/testcode", method=RequestMethod.POST)
	public String flashMessages(@RequestParam(value="code") String code, 
			RedirectAttributes redirectAttributes) {
        if (code.equals("bushido")){
        	return "redirect:/code";}
        else {
        	redirectAttributes.addFlashAttribute("error", "Train Harder");
        	return "redirect:/";
        }  
	}
	@RequestMapping("/code")
	public String code() {
        return "code.jsp";
	}
}

