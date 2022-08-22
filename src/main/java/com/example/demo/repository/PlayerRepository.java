package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Players;

@Repository
public interface PlayerRepository extends JpaRepository <Players, Integer>{

	Players findByNameAndPassword(String name, String password);
	
	@Query(value = "Select * FROM Player ORDER BY score DESC LIMIT 10", nativeQuery=true)
	List<Players> findTopPlayers();
	






}
