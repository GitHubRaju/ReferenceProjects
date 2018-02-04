/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outbottle.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author john
 */
@Controller
public class UserController {
    
	Map<String, List<String>> userDetails=new HashMap<>();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	   public String index(ModelMap map) {
	      System.out.println("UserApp started");
		   map.put("msg", "If you are New pls Register. Then login ");
	       return "index";
	   }
   
   
   @RequestMapping(value = "/register/{name}/{password}")
   public String register(@PathVariable String name, String password,ModelMap map) {
	   List<String> user=new ArrayList<>();
	   user.add(0, name);
	   user.add(1, password);
	   userDetails.put(name, user);
	   map.put("regSuccess", "U sucess fully reg");
       return "index";
   }
   
   @RequestMapping(value= "/login/{name}/{password}",method=RequestMethod.GET)    
   public String login(@PathVariable String name,String password, ModelMap model){
	   if(userDetails.containsKey(name)) {
		  Optional.ofNullable( userDetails.get(name).stream().filter(n->n.equals(password)).findFirst()).ifPresent(Uname->
		  {
			  model.put("msg", 'Y');
			  model.put("name", "U R Login Sucess ! "+name);
		  } );
	  }
	  else {
		  model.put("msg", "Pls Registe");
	  }
       return "index";
   }
   
   @RequestMapping(value = "/{name}", method = RequestMethod.GET)
   public String loginSucess(@PathVariable String name,ModelMap map) {
	   map.put("msg", name);
       return "sucess";
   }
   
}
