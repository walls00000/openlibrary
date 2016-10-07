package com.jolratf;

/**
 * Config is a class used to configure the RestService.
 * 
 * @author willwallace
 *
 */
public class Config {
	protected int port = 80;
	protected String baseUrl = "http://openlibrary.org";

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

}
