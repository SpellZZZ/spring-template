package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameData {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstPlayer;
	private String secondPlayer;
	
	
	public String display() {
		return "Game ID: " + id + ", First Player: "+ firstPlayer + ", Second Player: " + secondPlayer;
	}
	

	
	
}
