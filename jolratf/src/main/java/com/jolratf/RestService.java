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


/**
 * RestService is the the class containing the methods used to test RestServices.  
 * Each method of this class performs a single REST operation, and validation.  
 * Methods implement the "RestAssured" API and are written with the 
 * Given/When/Then syntax as is documented here: 
 * 
 * https://github.com/rest-assured/rest-assured/wiki/Usage.  
 * 
 * The RestAssured DSL supplies ample flexibility for validation.  The validation 
 * chosen in the methods below provide different approaches for different purposes.  
 * @author willwallace
 *
 */
public class RestService extends Config {
	
	/**
	 * getWithMatcher is a method which performs a single GET REST Call.  Validation  
	 * is performed against the supplied statusCode and matchers.  This type of 
	 * validation is intended for quick validation to verify a piece of the response 
	 * by passing in one or more hamcrest matchers.
	 * 
	 * @param headers The headers to be used in the call.
	 * @param target The target piece of the url starting with a '/'.
	 * @param statusCode The expected HTTP status code.
	 * @param matcher The matcher to use to verify the response is correct.
	 * @param additionalMatchers Optional matchers to further verify the response. 
	 * @return The response object is returned.
	 */
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
	
	/**
	 * getWithMatcher is a method which performs a single GET REST Call.  Validation  
	 * is performed against the supplied statusCode and deserializing a json response 
	 * into a passed in pojo object.  This type of validation is used when the form of 
	 * the response must conform to rigid standards.  Further validation should be 
	 * performed on the pojo object to verify proper fields are populated.
	 * @param <T>
	 * 
	 * @param headers The headers to be used in the call.
	 * @param target The target piece of the url starting with a '/'.
	 * @param statusCode The expected HTTP status code.
	 * @param pojo The 'Plain Old Java Object' to use for deserialization from the json response.
	 * @return The actual deserialized object is returned.
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public <T> Object getWithSchemeValidation(final Map<String, String> headers, final String target,
			final int statusCode, final Class<T> pojo) throws JsonParseException, JsonMappingException, IOException {
		System.out.println(baseUrl + target);
		Response response = given().port(port).contentType("application/json").when().get(baseUrl + target).then()
				.statusCode(statusCode).log().everything().extract().response();
		if (statusCode == 200) {
			ObjectMapper mapper = new ObjectMapper();
			Object obj = mapper.readValue(response.body().asString(), pojo);
			return (T) obj; // for further verification
		}
		return null;
	}
	
	
}
