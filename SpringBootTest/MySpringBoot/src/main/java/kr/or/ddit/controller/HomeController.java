package kr.or.ddit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("msg", "Change BOOOOOOOOOOT!!!!");
		model.addAttribute("man", "친구야!!!!");
		return "home";
	}

}
