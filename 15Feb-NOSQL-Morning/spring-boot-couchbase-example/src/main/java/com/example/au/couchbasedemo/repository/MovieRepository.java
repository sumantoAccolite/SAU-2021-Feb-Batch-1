package com.example.au.couchbasedemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.example.au.couchbasedemo.model.Movies;

public interface MovieRepository extends CrudRepository<Movies, String> {
	
	Movies findByName(String name);
//	ArrayList<String> findByCity(String cityId);
	void deleteByName(String name);

}