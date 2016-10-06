package com.jolratf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;
import org.testng.annotations.DataProvider;

import com.jolratf.json.Author;

public class RestDataProvider {

	
	@DataProvider(name = "getProvider")
	public static Object[][] getProvider() {
		final Map<String,String> headers = new HashMap<String,String>();
	    headers.put("accept", "application/json");
	    headers.put("accept-encoding", "gzip, deflate");
	    headers.put("user-agent", "jolratf");
		return new Object[][] {
			//Header, Target, StatusCode, Pojo
			{GetProvider.builder().headers(headers).target("/authors/OL1A.json").statusCode(200).pojo(Author.class).build()}
		};
	}
	
	@DataProvider(name = "queryTypeProvider")
	public static Object[][] queryTypeProvider() {
		final Map<String, String> headers = new HashMap<String, String>();
		headers.put("accept", "application/json");
		headers.put("accept-encoding", "gzip, deflate");
		headers.put("user-agent", "jolratf");

		return new Object[][] {
				// Header, Target, StatusCode, Matcher, Matchers
				{ GetProvider.builder().headers(headers).target("/query.json?type=/type/edition").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433363M"))
						.additionalMatchers(
								org.hamcrest.Matchers.containsString("/books/OL25433364M"),
								org.hamcrest.Matchers.containsString("/books/OL21478883M"),
								org.hamcrest.Matchers.containsString("/books/OL25433367M"),
								org.hamcrest.Matchers.containsString("/books/OL25433368M"),
								org.hamcrest.Matchers.containsString("/books/OL25433369M"),
								org.hamcrest.Matchers.containsString("/books/OL25433374M"),
								org.hamcrest.Matchers.containsString("/books/OL25433378M"),
								org.hamcrest.Matchers.containsString("/books/OL17910702M"),
								org.hamcrest.Matchers.containsString("/books/OL22691075M"),
								org.hamcrest.Matchers.containsString("/books/OL18497493M"),
								org.hamcrest.Matchers.containsString("/books/OL16241881M"),
								org.hamcrest.Matchers.containsString("/books/OL17860773M"),
								org.hamcrest.Matchers.containsString("/books/OL14825375M"),
								org.hamcrest.Matchers.containsString("/books/OL17210465M"),
								org.hamcrest.Matchers.containsString("/books/OL14825376M"),
								org.hamcrest.Matchers.containsString("/books/OL14825377M"),
								org.hamcrest.Matchers.containsString("/books/OL6034835M"),
								org.hamcrest.Matchers.containsString("/books/OL6036346M"),
								org.hamcrest.Matchers.containsString("/books/OL6032869M")).build()},
		};
	}
	
	@DataProvider(name = "getBookProvider")
	public static Object[][] getBookProvider() {
		final Map<String, String> headers = new HashMap<String, String>();
		headers.put("accept", "application/json");
		headers.put("accept-encoding", "gzip, deflate");
		headers.put("user-agent", "jolratf");

		return new Object[][] {
				{GetProvider.builder().headers(new HashMap<String,String>()).target("/books/OL25433364M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL25433364M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL21478883M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL21478883M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL25433367M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL25433367M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL25433368M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL25433368M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL25433369M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL25433369M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL25433374M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL25433374M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL25433378M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL25433378M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL17910702M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL17910702M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL22691075M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL22691075M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL18497493M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL18497493M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL16241881M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL16241881M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL17860773M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL17860773M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL14825375M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL14825375M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL17210465M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL17210465M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL14825376M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL14825376M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL14825377M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL14825377M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL6034835M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL6034835M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL6036346M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL6036346M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL6032869M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL6032869M")).build()}
		};

	}
	
	@DataProvider(name = "getRdfBookProvider")
	public static Object[][] getRdfBookProvider() {
		final Map<String, String> headers = new HashMap<String, String>();
		headers.put("accept", "application/json");
		headers.put("accept-encoding", "gzip, deflate");
		headers.put("user-agent", "jolratf");

		return new Object[][] {
				{GetProvider.builder().headers(new HashMap<String,String>()).target("/books/OL25433364M").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL25433364M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL21478883M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL21478883M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL25433367M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL25433367M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL25433368M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL25433368M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL25433369M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL25433369M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL25433374M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL25433374M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL25433378M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL25433378M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL17910702M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL17910702M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL22691075M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL22691075M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL18497493M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL18497493M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL16241881M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL16241881M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL17860773M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL17860773M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL14825375M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL14825375M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL17210465M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL17210465M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL14825376M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL14825376M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL14825377M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL14825377M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL6034835M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL6034835M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL6036346M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL6036346M")).build()},
				{GetProvider.builder().headers(headers).target("/books/OL6032869M.rdf").statusCode(200).matcher(org.hamcrest.Matchers.containsString("/books/OL6032869M")).build()}
		};

	}
	
}
