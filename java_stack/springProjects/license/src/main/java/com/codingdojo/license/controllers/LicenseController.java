package com.codingdojo.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.license.models.License;
import com.codingdojo.license.models.Person;
import com.codingdojo.license.services.LicenseService;
import com.codingdojo.license.services.PersonService;


@Controller
public class LicenseController {
	
	private final LicenseService licenseService;
	private final PersonService personService;
	
	
	public LicenseController(LicenseService licenseService, PersonService personService) {
		super();
		this.licenseService = licenseService;
		this.personService = personService;
	}
	@RequestMapping("/persons/new")
	public String newPerson(Model model) {
		Person person = new Person();
		model.addAttribute("person", person);
		return "person_new.jsp";
	}
	@RequestMapping("/licenses/new")
	public String newLicense(Model model) {
		License license = new License();
		model.addAttribute("license", license);
		List<Person> persons = personService.allPersons();
		model.addAttribute("persons",persons);
		return "license_new.jsp";
	}
	
	@RequestMapping("/create_person")
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
            return "person_new.jsp";
        } else {
            Person new_person = personService.createPerson(person);
            return "redirect:/persons/"+new_person.getId();
        }
	}
	@RequestMapping("/create_license")
	public String createLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if (result.hasErrors()) {
            return "license_new.jsp";
        } else {
        	String number = licenseService.generateLicenseNumber();
        	license.setNumber(number);
            License new_license = licenseService.createLicense(license);
            
            return "redirect:/persons/"+new_license.getPerson().getId();
        }

	}
	@RequestMapping("/persons/{id}")
	public String newPerson(Model model, @PathVariable("id") Long id) {
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		return "person.jsp";
	}
}
