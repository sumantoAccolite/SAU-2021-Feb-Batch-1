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

//import com.example.au.couchbasedemo.model.Blogs;
import com.example.au.couchbasedemo.model.Movies;
//import com.example.au.couchbasedemo.repository.BlogRepository;
import com.example.au.couchbasedemo.repository.MovieRepository;

@RestController
public class MovieController {
	
    @Autowired
    MovieRepository movieRepository;
    
	/*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    // [3] INSERT MOVIE 
    @PostMapping("/movies")
    public Movies addMovie(@RequestBody Movies newMovie) {
        return movieRepository.save(newMovie);
    }
    
//    @GetMapping("/movies/{cityId}")
//    public Optional<Movies> getMovie(@PathVariable String cityId) {
//        if (movieRepository.existsById(cityId)) {
//            return movieRepository.findById(cityId);
//        } else
//            return Optional.empty();
//    }
    
    // [1] SEARCH MOVIE_DETAILS BY NAME
    @GetMapping("/movies/name/{name}")
    public Movies getMovieByName(@PathVariable String name) {
    	System.out.print(movieRepository.findByName(name));
        return movieRepository.findByName(name);
    }
    // [2] SEARCH MOVIES BY CITY
    @GetMapping("/movies/city/{cityId}")
    public ArrayList<String> getMovieByCityId(@PathVariable String cityId) {
    	ArrayList<String> movieList = new ArrayList<>();
        movieRepository.findAll().forEach(Movie -> {
        	ArrayList<String> c = Movie.getCity();
        	System.out.println(c);
            if (c!=null && c.contains(cityId)) {
            	movieList.add(Movie.getName()); 
            }
        });

        return movieList;
    }
    // [4] Delete Movie By name
    @DeleteMapping("/movies/name/{name}")
    public void deleteByName(@PathVariable String name) {
    	movieRepository.deleteById(movieRepository.findByName(name).getId());
    }

//    @GetMapping("/blogs/tags/{tags}")
//    public List<Blogs> getBlogByTagName(@PathVariable List<String> tags) {
//        List<Blogs> blogsList=new ArrayList<>();
//        movieRepository.findAll().forEach(Blogs->{
//           List<String> tagsInBlog=Blogs.getTags();
//           for(String s:tags)
//           {
//               if(tagsInBlog.contains(s))
//               {
//                   blogsList.add(Blogs);
//                   break;
//               }
//           }
//       });
//
//
//            return blogsList;
//    }

}