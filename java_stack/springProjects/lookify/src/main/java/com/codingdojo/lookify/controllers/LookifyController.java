package com.codingdojo.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Lookify;
import com.codingdojo.lookify.services.LookifyService;

@Controller
public class LookifyController {
	private final LookifyService lookifyService;

	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
        List<Lookify> songs = lookifyService.allLookifys();
        model.addAttribute("songs", songs);
        return "dashboard.jsp";
    }
	
	@RequestMapping(value="/dashboard", method=RequestMethod.POST)
	public String addSong(@Valid @ModelAttribute("language") Lookify song, BindingResult result) {
		if (result.hasErrors()) {
            return "new.jsp";
        } else {
            lookifyService.createLookify(song);
            return "redirect:/dashboard";
        }
    }
	
	@RequestMapping("/search/topten")
	public String topTen(Model model) {
		List<Lookify> songs = lookifyService.findTop10();
        model.addAttribute("songs", songs);
        return "topten.jsp";
    }
	

	@RequestMapping("/search/{artist}")
	public String showArtist(Model model, @PathVariable("artist") String artist) {
		List<Lookify> songs = lookifyService.findByArtist(artist);
        model.addAttribute("songs", songs); 
        model.addAttribute("artist", artist);
        return "search.jsp";
    }

	@RequestMapping(value="/searchbar", method=RequestMethod.POST)
	public String searchArtist(@RequestParam("artist") String artist, Model model) {
		List<Lookify> songs = lookifyService.findByArtist(artist);
        model.addAttribute("songs", songs);
        return "redirect:/search/"+artist;
    }
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Lookify song) {
        return "new.jsp";
    }
	
	@RequestMapping("/songs/{id}")
	public String song(@PathVariable("id") String id, Model model) {
		Lookify song = lookifyService.findLookify((long) Integer.parseInt(id));
    	model.addAttribute("asong", song);
    	return "songs.jsp";
    }
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        lookifyService.deleteLookify(id);
        return "redirect:/dashboard";
    }

}
