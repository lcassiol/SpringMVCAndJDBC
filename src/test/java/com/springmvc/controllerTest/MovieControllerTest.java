package com.springmvc.controllerTest;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springmvc.config.MvcConfiguration;
import com.springmvc.dao.MovieDAO;
import com.springmvc.model.Movie;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcConfiguration.class})
public class MovieControllerTest {
	
	@Autowired
	private MovieDAO movieDAO;
	
	@Test
    public void testListAll() {
        Assert.assertNotNull(movieDAO.list());
    }
	
	@Test
    public void testInsert() {
		
		Movie mv = new Movie();
		mv.setDirector("James Cameron");
		mv.setName("The Terminator 2");
		mv.setSinopse("A seemingly indestructible humanoid cyborg is sent from 2029 to 1984 to assassinate a waitress, "
				+ "whose unborn son will lead humanity in a war against the machines, while a soldier from that war is sent to "
				+ "protect her at all costs.");
		mv.setStars("Arnold Schwarzenegger");
		mv.setWriters("James Cameron, William Wisher Jr.");
		mv.setYear(1991);
		mv.setGender("Action, Sci-Fi, Thriller");
		
		
        try {
        	int quantity = movieDAO.list().size();
			movieDAO.saveOrUpdate(mv);
			Assert.assertTrue(quantity < movieDAO.list().size());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
	
	@Test
    public void testRemove() {

		try {
			movieDAO.delete(4L);
			Assert.assertNull(movieDAO.get(4L));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
	
	@Test
    public void testGet() {
		
        try {
			Assert.assertNotNull(movieDAO.get(5L));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
	

}
