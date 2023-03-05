package com.example.demo.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import com.example.demo.dao.GameDataRepo;
import com.example.demo.model.GameData;
import com.example.demo.security.SpringSecurityConfig;


@Controller
public class webController {


	

	
	@RequestMapping(value  = { "/", "/main"}, method = RequestMethod.GET)
	public String start() {
				
		return "main";

	}
	
	@RequestMapping(value  = { "/wait"}, method = RequestMethod.GET)
	public String waitForGame() {
				
		return "wait";

	}
	

	@RequestMapping(value  = { "game"}, method = RequestMethod.GET)
	public String game() {
				
		return "game";

	}
	
	    
	
	
	

	
	
	
	
	
	
	
}
