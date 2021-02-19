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
public class Movies {
	
    
    
	@Id
    String id;
    
    @Field
    String name;
    
    @Field
    ArrayList<String> cityId;
    
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public ArrayList<String> getCity() {
		return cityId;
	}

	public void setCity(ArrayList<String> cityId) {
		this.cityId = cityId;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id=id;
	}

	public Movies(String id, String name, ArrayList<String> cityId) {
		super();
		this.id = id;
		this.name = name;
		this.cityId = cityId;
	}
}
