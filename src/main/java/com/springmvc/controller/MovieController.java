package com.springmvc.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springmvc.config.MvcConfiguration;
import com.springmvc.dao.MovieDAO;
import com.springmvc.model.Movie;


@Controller
public class MovieController {
	
	@Autowired
	private MovieDAO movieDAO;
	
	private static final Logger logger = Logger.getLogger(MovieController.class);
	
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> listMovie(){
		List<Movie> movies = movieDAO.list();
		Gson gson = new GsonBuilder().serializeNulls().create();

		logger.info("Method List was Called");
		
		return new ResponseEntity<Object>(gson.toJson(movies),HttpStatus.CREATED);
	}

	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> getMovie(@PathVariable Long id){
	 
		Gson gson = new GsonBuilder().serializeNulls().create();
		Movie movie;

		logger.info("Method Get was Called");
		
		try {
			movie = movieDAO.get(id);
		} catch (SQLException e) {
			logger.error("Method Get excpetion on called: " + e.getMessage());	
			return new ResponseEntity<Object>(null,HttpStatus.BAD_REQUEST);
		}
		
		
		return new ResponseEntity<Object>(gson.toJson(movie),HttpStatus.OK);
	}
	
	@RequestMapping(value = "movie/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Object> deleteMovie(@PathVariable Long id){
	 
		logger.info("Method Delete was Called");
		
		try {
			movieDAO.delete(id);
		} catch (SQLException e) {
			logger.error("Method Delete excpetion on called: " + e.getMessage());	
			return new ResponseEntity<Object>(null,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object>(null,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/save/", method = RequestMethod.POST, produces="application/json")
	public ResponseEntity<Object> saveMovie(@RequestBody Movie mv){
		
		logger.info("Method SaveMovie was Called");

		try {
			movieDAO.saveOrUpdate(mv);
		} catch (SQLException e) {
			logger.error("Method Save excpetion on called: " + e.getMessage());	
			return new ResponseEntity<Object>(null,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object>(null,HttpStatus.NO_CONTENT);
	}
	
}
