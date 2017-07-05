package fr.sedoo.dao;

import java.util.List;

// import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import java.util.ArrayList;
//import java.util.List;
//
//import javax.ws.rs.core.Response;
//
//import org.bibsonomy.model.BibTex;
//import org.bibsonomy.model.Post;
//import org.bibsonomy.model.logic.LogicInterface;
//import org.bibsonomy.rest.client.RestLogicFactory;
//import org.junit.Test;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;

public class BibsonomyDAOTest {

//	@Test
//	public void testGetAllPublications() {
//	BibsonomyDAO dao = new BibsonomyDAO();
//	List<Post<BibTex>> list = dao.getAllPublications("ericadegraaf");
//	System.out.println("number of publications: " + list.size());
//	
//	ObjectMapper mapper = new ObjectMapper();
//	String output = "";
//	try {
//		output = mapper.writeValueAsString(list);
//		
//	} catch (JsonProcessingException e) {
//		e.printStackTrace();
//	}
//	System.out.println(output);
//	
//	}
//	
	
//	@Test
//	public void testGetAllPublicationsByTags() {
//	
//	String tag = "ECCAD";
//	BibsonomyDAO dao = new BibsonomyDAO();
//	List<Post<BibTex>> list = dao.getAllPublicationsByTag(tag);
//	System.out.println("number of publications: " + list.size());
//	
//	ObjectMapper mapper = new ObjectMapper();
//	String output = "";
//	try {
//		output = mapper.writeValueAsString(list);
//		
//	} catch (JsonProcessingException e) {
//		e.printStackTrace();
//	}
//	System.out.println(output);
//	
//	}
	
//	@Test
//	public void testAddPublication() {
//	
//	String project = "ECCAD";
//	String firstName = "Erica";
//	String lastName = "de Graaf";
//	String title = "A test of Aeris Bibliography";
//	String year = "2017";
//	BibsonomyDAO dao = new BibsonomyDAO();
//	List<String> list = dao.addPublication(title, firstName, lastName, year, project);
//	
//	ObjectMapper mapper = new ObjectMapper();
//	String output = "";
//	try {
//		output = mapper.writeValueAsString(list);
//		
//	} catch (JsonProcessingException e) {
//		e.printStackTrace();
//	}
	
//	@Test
//	public void testUpgdatePublicationAddTag() {
//	
//	String firstName = "edwin";
//	String lastName = "Toledo";
//	String hash = "0ff112a4e3b5adbef61183fdbbd1e91d";
//	BibsonomyDAO dao = new BibsonomyDAO();
//	List<String> list = dao.updatePublicationAddAuthor(firstName, lastName, hash);
//	
//	ObjectMapper mapper = new ObjectMapper();
//	String output = "";
//	try {
//		output = mapper.writeValueAsString(list);
//		
//	} catch (JsonProcessingException e) {
//		e.printStackTrace();
//	}	
//	
//	
//	}
}
