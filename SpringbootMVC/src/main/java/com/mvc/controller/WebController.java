package com.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WebController {
	
	@RequestMapping("/well")
	public ModelAndView wellcomeJsp()
	{
		ModelAndView mav=new ModelAndView();
		mav.addObject("wish", "Wellcome world");
		mav.setViewName("index");
		return mav;
	}
@RequestMapping("/get")
	public ModelAndView get(@RequestParam("name")String name)
	{
	System.out.println(name);
		ModelAndView mav=new ModelAndView();
		mav.addObject("name",name.toUpperCase());
		mav.setViewName("index");
		return mav;
	}
}
