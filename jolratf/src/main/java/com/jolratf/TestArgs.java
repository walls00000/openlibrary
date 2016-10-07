package com.jolratf;

import java.util.Arrays;
import java.util.Map;

import org.hamcrest.Matcher;
/**
 * TestArgs is a class to facilitate the passing of arguments from a data provider to its test.  
 * The size of the array returned from a data provider must match the number of arguments in a 
 * test method signature, therefore this relationship is critical.  Keeping the test arguments 
 * to one, and facilitating building arguments with an object and builder simplifies the 
 * relationship, and facilitates the creation of datasets and tests. 
 * 
 * @author willwallace
 * @param <T>
 *
 */
public class TestArgs {
	private Map<String, String> headers;
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

	@SuppressWarnings("unchecked")
	public <T> Class<T> getPojo() {
		return (Class<T>)pojo;
	}

	public void setPojo(Object pojo) {
		this.pojo = pojo;
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

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public String toString() {
		return "TestArgs [headers=" + headers + ", target=" + target + ", statusCode=" + statusCode + ", matcher="
				+ matcher + ", additionalMatchers=" + Arrays.toString(additionalMatchers) + ", pojo=" + pojo + "]";
	}

	

}

/**
 * Builder is an inner class to TestArgs which facilitates the building of a TestArgs instance.
 * @author willwallace
 *
 */
class Builder {
	private final TestArgs provider;

	public Builder() {
		provider = new TestArgs();
	}

	public Builder headers(final Map<String, String> headers) {
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

	public TestArgs build() {
		return provider;
	}

}
