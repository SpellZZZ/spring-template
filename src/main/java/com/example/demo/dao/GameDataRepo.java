package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.GameData;
import com.example.demo.model.UserData;


public interface GameDataRepo extends JpaRepository<GameData, Integer>{
	GameData findByFirstPlayer(String firstPlayer);
	GameData findBySecondPlayer(String secondPlayer);
	
}