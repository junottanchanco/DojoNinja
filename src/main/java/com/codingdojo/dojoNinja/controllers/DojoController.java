package com.codingdojo.dojoNinja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojoNinja.models.Dojo;
import com.codingdojo.dojoNinja.services.DojoService;
import com.codingdojo.dojoNinja.services.NinjaService;

@Controller
//@RequestMapping("/")
public class DojoController {
	
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public DojoController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/dojo/new";
	}
	
	@RequestMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	@PostMapping("/dojo/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/dojo/new";
		}else {
			dojoService.addDojo(dojo);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/dojo/show/{id}")
	public String showDojo(Model model, @PathVariable("id") Long id) {
		model.addAttribute("dojo", dojoService.findDojoById(id));
		model.addAttribute("ninjas", ninjaService.findNinjaByDojo(id));
		return "showDojo.jsp";
	}
}
