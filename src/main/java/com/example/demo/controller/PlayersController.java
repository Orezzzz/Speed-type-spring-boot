package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Players;
import com.example.demo.repository.PlayerRepository;

@RestController
@CrossOrigin
public class PlayersController {

	 @Autowired
	    PlayerRepository repo;

	    @PostMapping("/add")
	    public Players addPlayer(@RequestBody Players player){
	    	repo.save(player);
	        return player;
	    }

	    @GetMapping("/getAll")
	    public List<Players> getPlayers(){
	        return repo.findAll();
	    }
	    
	    @GetMapping("/getTopPlayers")
	    public List<Players> getTopPlayers(){
	        return repo.findTopPlayers();
	    }
	    
	   /* @GetMapping("/getAll/{name}")
	    public Player getPlayer(@PathVariable("name") String name){
	        return repo.findByName(name);
	    }
	    
	    @GetMapping("/getAll/{name}/{password}")
	    public Player getPlayer(@PathVariable String name, @PathVariable String password){
	        return repo.findByNameAndPassword(name, password);
	    }*/
	    
	    
	    @PutMapping("/update/{name}/{password}")
	    public Players updatePlayer(@PathVariable String name, @PathVariable String password, @RequestBody Players player){
	    	
	    	Players updatePlayer = repo.findByNameAndPassword(name, password);
	    	
	    	updatePlayer.setScore(player.getScore());
	    	repo.save(updatePlayer);
	    	
	        return updatePlayer;
	    }
}
