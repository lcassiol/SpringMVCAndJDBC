package com.springmvc.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.springmvc.dao.MovieDAO;
import com.springmvc.dao.impl.MovieDAOImpl;
import com.springmvc.utils.Constants;
import com.springmvc.utils.Utils;

@Configuration
@ComponentScan(basePackages="com.springmvc")
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	private static final Logger logger = Logger.getLogger(MvcConfiguration.class);
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        try {
			dataSource.setDriverClassName(Utils.getProperty(Constants.DB_DRIVER_CLASS_NAME).trim());
			dataSource.setUrl(Utils.getProperty(Constants.DB_URL).trim());
			logger.info("Connection JDBC with: " + Utils.getProperty(Constants.DB_URL).trim());
			
			dataSource.setUsername(Utils.getProperty(Constants.DB_USERNAME).trim());
			dataSource.setPassword(Utils.getProperty(Constants.DB_PASSWORD).trim());
		} catch (Exception e) {
			logger.error("Problems to read a propertie on db.properties: " + e.getMessage());
		}
         
        return dataSource;
    }
	
	@Bean
	public MovieDAO getMovieDAO(){
		return new MovieDAOImpl(getDataSource());
	}
	
}
