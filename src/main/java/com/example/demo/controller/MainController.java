package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.dao.GameDataRepo;
import com.example.demo.model.GameData;
import com.example.demo.security.SpringSecurityConfig;

@RestController
@RequestMapping("def")
public class MainController {

	
	
	@Autowired
	GameDataRepo gameRepo;
	

	@RequestMapping(value  = "/gameList", method = RequestMethod.GET)
	public List<GameData> showGames() {
		
		
		List<GameData> detailList = gameRepo.findAll();

		return detailList;
		
		

	}

	
	
	

	@RequestMapping(value  = "/createGame", method = RequestMethod.GET)
	public GameData creatGame() {
		
			String s = SpringSecurityConfig.getCurrentUserLogin().get();
		
		
			
			GameData game = new GameData();
		

			
			if(gameRepo.findByFirstPlayer(s) == null && gameRepo.findBySecondPlayer(s) == null)
			{
				game.setFirstPlayer(s);
				game.setSecondPlayer(null);
					
				gameRepo.save(game);
				
				
			}

		
	

		return game;
		
		
	}
	
	
	
	
	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	@ResponseBody
	public GameData joinGame(@RequestParam(name = "id") int id) { 
		
		String s = SpringSecurityConfig.getCurrentUserLogin().get();
		//wyjatek ??
		
		GameData game = gameRepo.findById(id).get();
		
		
		
		if(gameRepo.findByFirstPlayer(s) != null && gameRepo.findBySecondPlayer(s) != null ) {
			
			return game;
		}
		
		if(game.getFirstPlayer().equals(s)) {
			return game;
		}
		

		
			game.setSecondPlayer(s);
			
			
			gameRepo.save(game);
			
	
	    return game;
	}	    
	
	
	
	
	@RequestMapping(value = "/getGame", method = RequestMethod.GET)
	@ResponseBody
	public GameData getGame(@RequestParam(name = "id") int id) { 
		

		GameData game = gameRepo.findById(id).get();
		
		if(game.getFirstPlayer() == null || game.getSecondPlayer() == null) {
			return null;
		}
	
	    return game;
	}	  
	
	
}
