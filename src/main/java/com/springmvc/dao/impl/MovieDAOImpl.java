package com.springmvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.dao.MovieDAO;
import com.springmvc.model.Movie;

public class MovieDAOImpl implements MovieDAO{

    private JdbcTemplate jdbcTemplate;
 
    public MovieDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	public void saveOrUpdate(Movie mv) throws SQLException {
		try 
		{
			
			if (mv.getId() != null && mv.getId() > 0) {
			        // update
			        String sql = "UPDATE Movie SET name=?, director=?, writers=?, "
			                    + "year=?, sinopse=?, stars=?, gender=?  WHERE id=?";
			        jdbcTemplate.update(sql, mv.getName(), mv.getDirector(),
			        		mv.getWriters(), mv.getYear(), mv.getSinopse(), mv.getStars(), mv.getGender() ,mv.getId());
			    } else {
			        // insert
			        String sql = "INSERT INTO Movie (name, director, writers, year, sinopse, stars, gender)"
			                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
			        jdbcTemplate.update(sql, mv.getName(), mv.getDirector(), mv.getWriters(), mv.getYear(),
			        		mv.getSinopse(), mv.getStars(), mv.getGender());
			    }
		} catch (Exception e) {
			throw new SQLException();
		}
		
	}

	public void delete(Long movieId) throws SQLException {
		try {
			String sql = "DELETE FROM Movie WHERE id=?";
			jdbcTemplate.update(sql, movieId);
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	public Movie get(Long movieId) throws SQLException {
		try {
			
		  String sql = "SELECT * FROM Movie WHERE id=" + movieId;
		   return jdbcTemplate.query(sql, new ResultSetExtractor<Movie>() {
		 
		        public Movie extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	Movie mv = new Movie();
		            	mv.setId(rs.getLong("id"));
		            	mv.setName(rs.getString("name"));
		            	mv.setDirector(rs.getString("director"));
		            	mv.setGender(rs.getString("gender"));
		            	mv.setSinopse(rs.getString("sinopse"));
		            	mv.setStars(rs.getString("stars"));
		            	mv.setWriters(rs.getString("stars"));
		            	mv.setYear(rs.getInt("year"));

		            	return mv;
		            }
		 
		            return null;
		        }
		 
		    });
		    
		} catch (Exception e) {
			throw new SQLException();
		}
	}

	public List<Movie> list() {
		
		String sql = "SELECT * FROM Movie";
	    List<Movie> listMovie = jdbcTemplate.query(sql, new RowMapper<Movie>() {
	 
	        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Movie movie = new Movie();
	 
	        	movie.setId(rs.getLong("id"));
	        	movie.setDirector(rs.getString("director"));
	        	movie.setGender(rs.getString("gender"));
	        	movie.setName(rs.getString("name"));
	        	movie.setSinopse(rs.getString("sinopse"));
	        	movie.setStars(rs.getString("stars"));
	        	movie.setWriters(rs.getString("writers"));
	        	movie.setYear(rs.getInt("year"));
	 
	            return movie;
	        }
	 
	    });
		
		
		return listMovie;
	}

}
