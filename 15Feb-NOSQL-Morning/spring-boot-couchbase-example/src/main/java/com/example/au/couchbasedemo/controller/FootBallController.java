package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.FootBall;
//import com.example.au.couchbasedemo.model.Blogs;
//import com.example.au.couchbasedemo.model.Movies;
import com.example.au.couchbasedemo.repository.FootBallRepository;
//import com.example.au.couchbasedemo.repository.BlogRepository;
import com.example.au.couchbasedemo.repository.MovieRepository;

@RestController
public class FootBallController {
	
    @Autowired
    FootBallRepository footBallRepository;
    
	
    // [1] INSERT FOOTBALL INFO 
    @PostMapping("/football")
    public FootBall addMovie(@RequestBody FootBall newFootball) {
        return footBallRepository.save(newFootball);
    }
    int count=0;
    
    @GetMapping("/football/")
    public ArrayList<String> getMovieByCityId() {
    	ArrayList<String> x=new ArrayList<String>();
    	footBallRepository.findAll().forEach(record -> {
        	int goals = record.getGoals();
        	if(goals>10)
        		x.add(record.getName());
        });

        return x;
    }

}