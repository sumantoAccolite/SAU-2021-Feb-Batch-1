package com.example.au.couchbasedemo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import com.sun.istack.NotNull;

@Document
public class FootBall {
	
	@Id
    String id;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}
	
    @Field
    String name;
    
    @Field
    int goals;
    
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals=goals;
	}

	public FootBall(String id,int goals, String name) {
		super();
		this.goals = goals;
		this.name = name;
		this.id=id;
	}
}
