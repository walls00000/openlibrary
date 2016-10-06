package com.jolratf;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import java.io.IOException;
import java.util.Map;

import org.hamcrest.Matcher;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.response.Response;
import com.jolratf.json.Author;

public class RestService extends Config {
	
	public Response getWithMatcher(final Map<String,String> headers, final String target, final int statusCode, final Matcher<?> matcher, Matcher<?> ...additionalMatchers) {
	    System.out.println(baseUrl + target);
		Response response = 
	    given().port(port).
	        contentType("application/json").
	    when().
	        get(baseUrl + target).
	    then().body(matcher, additionalMatchers).
	        statusCode(statusCode).log().everything().extract().response();
		response.body();
		return response;
	}
	
	public Object getWithSchemeValidation(
			final Map<String,String> headers, 
			final String target, 
			final int statusCode, 
			final Object pojo) throws JsonParseException, JsonMappingException, IOException {
	    System.out.println(baseUrl + target);
		Response response = 
	    given().port(port).
	        contentType("application/json").
	    when().
	        get(baseUrl + target).
	    then().
	        statusCode(statusCode).log().everything().extract().response();
		ObjectMapper mapper = new ObjectMapper();
		Author obj = mapper.readValue(response.body().asString(), Author.class);
		return obj; //for further verification
	}
	
	public void getUserData() {
	    given().
	        contentType("application/json").
	    when().
	        get("http://openlibrary.org/authors/OL1A.json").
	    then().
	        body(containsString("Sachi Rautroy")).
	        statusCode(200);
	}
	
}
