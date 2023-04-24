package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Address;
import com.example.model.person;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		
			 SpringApplication.run(Application.class, args); 
		      try {
		    	  ObjectMapper mapper = new ObjectMapper();
		          InputStream inputStream = new FileInputStream(new File("C:\\Users\\sagarw14\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\application\\src\\main\\resources\\personout.json"));
		          TypeReference<List<person>> typeReference = new TypeReference<List<person>>() {};
		          List<person> persons = mapper.readValue(inputStream,typeReference);
		          for (person p : persons) {
		        	  System.out.println("name is "+p.getFirstName()+" City is "+p.getAddress().getCity()+" first car is "+p.getCars()[0]);
		          }
		          person person = new person();
		          person.setFirstName("Rahul");
		          person.setLastName("Dev");
		          person.setAge(25);
		          person.setAddress(new Address("12 street","Redmond","98825"));
		          person.setCars(new String[] {"Fortuner","Gvagon"});
		          mapper.writeValue(new File("C:\\\\Users\\\\sagarw14\\\\Documents\\\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\\\application\\\\src\\\\main\\\\resources\\\\person.json"), person);
		          inputStream.close();
		      } catch (FileNotFoundException e) {
		    	  e.printStackTrace();
		      } catch (JsonParseException e) {
		    	  e.printStackTrace();
		      }catch (JsonMappingException e) {
		         e.printStackTrace();  
		      }   catch (IOException e) {
		  	  e.printStackTrace();
		      }
	}

}
