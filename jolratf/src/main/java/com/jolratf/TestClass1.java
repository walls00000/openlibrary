package com.jolratf;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class TestClass1 {
	
	@Test(description = "test GET with matcher") 
	
	public void test2() {
		RestService service = new RestService();
	    final Map<String,String> headers = new HashMap<String,String>();
	    headers.put("accept", "application/json");
	    headers.put("accept-encoding", "gzip, deflate");
	    headers.put("user-agent", "jolratf");
	    final String target = "/authors/OL1A.json";
	    final int statusCode = 200;
	    Matcher<String> matcher1 = org.hamcrest.Matchers.containsString("Sachi Rautroy");
	    Matcher<String> matcher2 = org.hamcrest.Matchers.containsString("2004");
		service.getWithMatcher(headers, target, statusCode, matcher1, matcher2);
	}
	
	@Test(description = "Test GET with  schema validaton")
	public void test3() throws JsonParseException, JsonMappingException, IOException {
		RestService service = new RestService();
	    final Map<String,String> headers = new HashMap<String,String>();
	    headers.put("accept", "application/json");
	    headers.put("accept-encoding", "gzip, deflate");
	    headers.put("user-agent", "jolratf");
	    final String target = "/authors/OL1A.json";
	    final int statusCode = 200;
		service.getWithSchemeValidation(headers, target, statusCode, "authors-definition.json");
	}
	
	@Test(description = "Test GET with schema and dataProvider", dataProvider = "getProvider", dataProviderClass = RestDataProvider.class)
	public void test4(final GetProvider provider) throws JsonParseException, JsonMappingException, IOException {
		RestService service = new RestService();
		final Object obj = service.getWithSchemeValidation(
				provider.getHeaders(), 
				provider.getTarget(), 
				provider.getStatusCode(), 
				provider.getPojo());
	}
	
	@Test(description = "A vanilla test") 
	public void test1() {
		RestService rs = new RestService();
		rs.getUserData();
	}
	
}
