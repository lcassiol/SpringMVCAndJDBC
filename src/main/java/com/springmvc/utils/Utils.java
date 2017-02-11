package com.springmvc.utils;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;

public class Utils {

	private static Properties getProperties() throws IOException {

        ClassPathResource cpr = new ClassPathResource("db.properties");

        Properties props = new Properties();
        props.load(cpr.getInputStream());

        return props;
    }
    
    public static String getProperty(String propertyName) throws IOException{
        return (String) getProperties().get(propertyName);
    }
}
