package com.jolratf;

import java.util.Map;

public class GetProvider {
	private Map<String,String> headers;
	private String target;
	private int statusCode;
	private Object pojo;
	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Object getPojo() {
		return pojo;
	}
	public void setPojo(Object pojo) {
		this.pojo = pojo;
	}
	
	public static Builder builder() {
		return new Builder();
	}
}
class Builder {
	private final GetProvider provider;
	public Builder() {
		provider = new GetProvider();
	}
	public Builder headers(final Map<String,String> headers) {
		provider.setHeaders(headers);
		return this;
	}
	public Builder target(final String target) {
		provider.setTarget(target);
		return this;
	}
	public Builder statusCode(final int statusCode) {
		provider.setStatusCode(statusCode);
		return this;
	}
	public Builder pojo(final Object pojo) {
		provider.setPojo(pojo);
		return this;
	}
	public GetProvider build() {
		return provider;
	}
	
	
}
