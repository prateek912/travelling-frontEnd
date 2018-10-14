package com.shubhamtravels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView start() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Home Page");
		mv.addObject("userClickedHome",true);
		
		return mv;
	}
}
