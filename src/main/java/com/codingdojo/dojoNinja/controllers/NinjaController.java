package com.codingdojo.dojoNinja.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojoNinja.models.Ninja;
import com.codingdojo.dojoNinja.services.DojoService;
import com.codingdojo.dojoNinja.services.NinjaService;

@Controller
public class NinjaController {
	
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.ninjaService = ninjaService;
		this.dojoService = dojoService;
	}
	
	@RequestMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", dojoService.allDojos());
		return "newNinja.jsp";
	}
	@PostMapping("/ninja/new")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", dojoService.allDojos());
			return "newNinja.jsp";
		}else {
			ninjaService.addNinja(ninja);
			return "redirect:/";
		}
	}
}
