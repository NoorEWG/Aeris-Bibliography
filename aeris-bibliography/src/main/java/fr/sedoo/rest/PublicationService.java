package fr.sedoo.rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bibsonomy.model.BibTex;
import org.bibsonomy.model.Post;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.sedoo.dao.BibsonomyDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;

@Path("/publication")
@Api( value = "/publication", description = "Manage publications" )
public class PublicationService {
		
	@Path("/all/{username}")
	@GET
	@ApiOperation( 
		    value = "Find publications by username", 
		    notes = "Find publications by username"
		)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllPublications(
			@ApiParam( value = "username", required = true ) 
			@PathParam("username") String username) {
		
		BibsonomyDAO dao = new BibsonomyDAO();
		List<Post<BibTex>> list = dao.getAllPublications(username);
		ObjectMapper mapper = new ObjectMapper();
		String output;
		try {
			output = mapper.writeValueAsString(list);
			return Response.status(200).entity(output).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("Something went wrong").build();
		
	}
	
	
	@Path("/tag/{tag}")
	@GET
	@ApiOperation( 
		    value = "Find publications by tag", 
		    notes = "Find publications by tag"
		)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPublicationsByTag(
			@ApiParam( value = "tag", required = true ) 
			@PathParam("tag") String tag) {
		
		BibsonomyDAO dao = new BibsonomyDAO();
		List<Post<BibTex>> list = dao.getAllPublicationsByTag(tag);
		ObjectMapper mapper = new ObjectMapper();
		String output;
		try {
			output = mapper.writeValueAsString(list);
			return Response.status(200).entity(output).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("Something went wrong").build();
		
	}
	

	@Path("/search/{searchString}")
	@GET
	@ApiOperation( 
		    value = "Find publications by searchterm", 
		    notes = "Find publications by searchterm"
		)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPublicationsBySearchTerm(
			@ApiParam( value = "tag", required = true ) 
			@PathParam("searchString") String searchString) {
		
		BibsonomyDAO dao = new BibsonomyDAO();
		List<Post<BibTex>> list = dao.getAllPublicationsBySearchString(searchString);
		ObjectMapper mapper = new ObjectMapper();
		String output;
		try {
			output = mapper.writeValueAsString(list);
			return Response.status(200).entity(output).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("Something went wrong").build();
		
	}
	
	@Path("/hash/{resourceHash}")
	@GET
	@ApiOperation( 
		    value = "Find a publication by the resourcehash (=unique identifier)", 
		    notes = "Find publications by the resourcehash (=unique identifier)"
		)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPublicationByResourceHash(
			@ApiParam( value = "resourceHash", required = true ) 
			@PathParam("resourceHash") String resourceHash) {
		
		BibsonomyDAO dao = new BibsonomyDAO();
		List<Post<BibTex>> list = dao.getPublicationByResourceHash(resourceHash);
		ObjectMapper mapper = new ObjectMapper();
		String output;
		try {
			output = mapper.writeValueAsString(list);
			return Response.status(200).entity(output).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("Something went wrong").build();
		
	}
	
	@Path("/add")
	@POST
	@ApiOperation( 
		    value = "Add a publication", 
		    notes = "Add a publication"
		)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPublication(
			@ApiParam( value = "title", required = true ) 
			@QueryParam("title") String title,
			@ApiParam( value = "firstname", required = true ) 
			@QueryParam("firstname") String firstName,
			@ApiParam( value = "lastname", required = true ) 
			@QueryParam("lastname") String lastName,
			@ApiParam( value = "year", required = true ) 
			@QueryParam("year") String year,
			@ApiParam( value = "project", required = true ) 
			@QueryParam("project") String project) {
		
		BibsonomyDAO dao = new BibsonomyDAO();
		List<String> list = dao.addPublication(title, firstName, lastName, year, project);
		ObjectMapper mapper = new ObjectMapper();
		String output;
		try {
			output = mapper.writeValueAsString(list);
			return Response.status(200).entity(output).build();
					//.header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT").build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("Something went wrong").build();
	}
	
	
	@Path("/update/add/tag/{tag}/{hash}")
	@PUT
	@ApiOperation( 
		    value = "Add a tag to an existing publication", 
		    notes = "Add a tag to an existing publication"
		)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePublicationAddTag(
			@ApiParam( value = "tag", required = true ) 
			@PathParam("tag") String tag,
			@ApiParam( value = "hash", required = true ) 
			@PathParam("hash") String hash) {
		
		BibsonomyDAO dao = new BibsonomyDAO();
		List<String> list = dao.updatePublicationAddTag(tag, hash);
		ObjectMapper mapper = new ObjectMapper();
		String output;
		try {
			output = mapper.writeValueAsString(list);
			return Response.status(200).entity(output).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("Something went wrong").build();
	}
	
	
	@Path("/update/add/abstract/{abstract}/{hash}")
	@PUT
	@ApiOperation( 
		    value = "Add an abstract to an existing publication", 
		    notes = "Add an abstract to an existing publication"
		)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePublicationAddAbstract(
			@ApiParam( value = "abstract", required = true ) 
			@PathParam("abstract") String description,
			@ApiParam( value = "hash", required = true ) 
			@PathParam("hash") String hash) {
		
		BibsonomyDAO dao = new BibsonomyDAO();
		List<String> list = dao.updatePublicationAddAbstract(description, hash);
		ObjectMapper mapper = new ObjectMapper();
		String output;
		try {
			output = mapper.writeValueAsString(list);
			return Response.status(200).entity(output).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("Something went wrong").build();
	}
	
	
	@Path("/update/add/url/{url}/{hash}")
	@PUT
	@ApiOperation( 
		    value = "Add an url to an existing publication", 
		    notes = "Add an url to an existing publication"
		)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePublicationAddUrl(
			@ApiParam( value = "url", required = true ) 
			@PathParam("url") String url,
			@ApiParam( value = "hash", required = true ) 
			@PathParam("hash") String hash) {
		
		BibsonomyDAO dao = new BibsonomyDAO();
		List<String> list = dao.updatePublicationAddUrl(url, hash);
		ObjectMapper mapper = new ObjectMapper();
		String output;
		try {
			output = mapper.writeValueAsString(list);
			return Response.status(200).entity(output).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("Something went wrong").build();
	}
	
	
	@Path("/update/add/author/{hash}")
	@PUT
	@ApiOperation( 
		    value = "Add an author to an existing publication", 
		    notes = "Add an author to an existing publication"
		)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePublicationAddUrl(
			@ApiParam( value = "hash", required = true ) 
			@PathParam("hash") String hash,
			@ApiParam( value = "firstname", required = true ) 
			@QueryParam("firstname") String firstName,
			@ApiParam( value = "lastname", required = true ) 
			@QueryParam("lastname") String lastName) {
		
		BibsonomyDAO dao = new BibsonomyDAO();
		List<String> list = dao.updatePublicationAddAuthor(firstName, lastName, hash);
		ObjectMapper mapper = new ObjectMapper();
		String output;
		try {
			output = mapper.writeValueAsString(list);
			return Response.status(200).entity(output).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return Response.status(400).entity("Something went wrong").build();
	}
	
}
