package com.codingdojo.ninjasdojos.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.codingdojo.ninjasdojos.models.Tag;
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
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "new_dojo.jsp";
	}
	@RequestMapping("/create_dojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
            return "new_dojo.jsp";
        } else {
        	String[] tags_split = dojo.getTagString().trim().split("\\s*,\\s*");
        	ArrayList<Tag> tags = new ArrayList<Tag>();
        	for (int i=0; i<tags_split.length;i++) {
        		Tag possibleTag= tagService.findTagByName(tags_split[i]);
        		if (possibleTag==null) {
        		Tag new_tag = new Tag(tags_split[i]);
        		tagService.createTag(new_tag);
        		tags.add(new_tag);
        		}
        		else {
        			tags.add(possibleTag);
        		}
        		
           }
        	dojo.setTags(tags);
        	Dojo new_dojo = dojoService.createDojo(dojo);
        	return "redirect:/dojos/"+new_dojo.getId();
        }
	}
	@RequestMapping("/dojos/{id}")
	public String createDojo(@PathVariable("id") Long id, Model model) {
//		Dojo dojo = dojoService.findDojo(id);
//		model.addAttribute("dojo",dojo);
		List<Object[]> dojoAndNinjas = dojoService.getAllDojosWithNinjasByID(id);
		model.addAttribute("dojoNinja",dojoAndNinjas);
            return "dojo.jsp";
        }
	
	@RequestMapping("/dojos/edit/{id}")
	public String editDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		List<Tag> current_tags = dojo.getTags();
		List<Tag> other_tags = tagService.allTags();
		other_tags.removeAll(current_tags);
 		model.addAttribute("dojo",dojo);
 		model.addAttribute("other_tags",other_tags);
 		Tag tag = new Tag();
 		model.addAttribute("tag", tag);
            return "edit_dojo.jsp";
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
	@RequestMapping("/add_tag/{dojo_id}")
	public String add_tag(@Valid @ModelAttribute("tag") Tag tag, @PathVariable("dojo_id") Long id) {
		Dojo dojo = dojoService.findDojo(id);
		Tag add_tag = tagService.findTag(tag.getId());
		List<Tag> tags =  dojo.getTags();
		tags.add(add_tag);
		dojo.setTags(tags);
		dojoService.updateDojo(dojo);
		return "redirect:/dojos/all";
	}
}
