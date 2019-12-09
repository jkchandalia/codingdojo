package com.codingdojo.ninjasdojos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.ninjasdojos.models.Dojo;
import com.codingdojo.ninjasdojos.models.Ninja;
import com.codingdojo.ninjasdojos.services.DojoService;
import com.codingdojo.ninjasdojos.services.NinjaService;
import com.codingdojo.ninjasdojos.services.TagService;

@Controller
public class NinjaDojoController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	private final TagService tagService;
	public NinjaDojoController(NinjaService ninjaService, DojoService dojoService, TagService tagService) {
		super();
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
		this.tagService = tagService;
	}
	@RequestMapping("/dojos/new")
	public String index(Model model) {
		Dojo dojo = new Dojo();
		model.addAttribute("dojo", dojo);
		return "new_dojo.jsp";
	}
	@RequestMapping("/create_dojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
            return "new_dojo.jsp";
        } else {
            Dojo new_dojo = dojoService.createDojo(dojo);
            return "redirect:/dojos/"+new_dojo.getId();
        }
	}
	@RequestMapping("/dojos/{id}")
	public String createDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo",dojo);
            return "dojo.jsp";
        }

	@RequestMapping("/dojos/all")
	public String createDojo(Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos",dojos);
            return "all_dojos.jsp";
        }
	@RequestMapping("/ninjas/new")
	public String ninja(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "new_ninja.jsp";
	}
	@RequestMapping("/create_ninja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, 
			BindingResult result,
			@RequestParam("dojo") Long id) {
		if (result.hasErrors()) {
            return "new_dojo.jsp";
        } else {
        	Dojo dojo = dojoService.findDojo(id);
        	ninja.setDojo(dojo);
            Ninja new_ninja = ninjaService.createNinja(ninja);
            return "redirect:/dojos/"+new_ninja.getDojo().getId();
        }
	}
}
