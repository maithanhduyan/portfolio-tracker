package com.portfoliotracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String homePage() {
		return "index";
	}
	@RequestMapping("/500")
	public String _500Page() {
		return "500";
	}
	@RequestMapping("/404")
	public String _404Page() {
		return "404";
	}
}
