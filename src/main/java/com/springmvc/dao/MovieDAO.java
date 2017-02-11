package com.springmvc.dao;

import java.sql.SQLException;
import java.util.List;

import com.springmvc.model.Movie;

public interface MovieDAO {
	
	public void saveOrUpdate(Movie movie) throws SQLException;
     
    public void delete(Long id) throws SQLException;
     
    public Movie get(Long movieId) throws SQLException;
     
    public List<Movie> list();

}
