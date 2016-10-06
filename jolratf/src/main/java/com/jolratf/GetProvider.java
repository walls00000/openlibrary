package com.jolratf;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;

public class GetProvider {
	private Map<String,String> headers;
	private String target;
	private int statusCode;
	private Matcher<?> matcher;
	private Matcher<?>[] additionalMatchers;
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
	public Matcher<?> getMatcher() {
		return matcher;
	}
	public void setMatcher(Matcher<?> matcher) {
		this.matcher = matcher;
	}
	public Matcher<?>[] getAdditionalMatchers() {
		return additionalMatchers;
	}
	public void setAdditionalMatchers(Matcher<?>[] additionalMatchers) {
		this.additionalMatchers = additionalMatchers;
	}
	@Override
	public String toString() {
		return "GetProvider [headers=" + headers + ", target=" + target + ", statusCode=" + statusCode + ", matcher="
				+ matcher + ", additionalMatchers=" + Arrays.toString(additionalMatchers) + ", pojo=" + pojo + "]";
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
	public Builder matcher(final Matcher<?> matcher) {
		provider.setMatcher(matcher);
		return this;
	}
	public Builder additionalMatchers(final Matcher<?>... matchers) {
		provider.setAdditionalMatchers(matchers);
		return this;
	}
	public GetProvider build() {
		return provider;
	}

	
}
