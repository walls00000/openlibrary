package com.jolratf;


import com.jayway.restassured.RestAssured;

public class Config {
	protected int port = 80;
	protected String baseUrl = "http://openlibrary.org";
	public Config() {
//		RestAssured.useRelaxedHTTPSValidation();
	}
}
