package com.jolratf;

import java.util.HashMap;
import java.util.Map;

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
}
