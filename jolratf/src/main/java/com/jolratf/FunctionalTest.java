package com.jolratf;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class FunctionalTest {
	/**
	 * This test fetches various authors specified by the data provider
	 * @param provider
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@Test(description = "Test GET Author", dataProvider = "getAuthorProvider", dataProviderClass = RestDataProvider.class)
	public void testAuthor(final TestArgs provider) throws JsonParseException, JsonMappingException, IOException {
		RestService service = new RestService();
		final Object obj = service.getWithSchemeValidation(
				provider.getHeaders(), 
				provider.getTarget(), 
				provider.getStatusCode(), 
				provider.getPojo());
		//TODO further validation on the returned object
		rateLimit(1L);
	}
	
	/**
	 * This Test performs a get to query various types.
	 * @param provider
	 */
	@Test(description = "Test GET Query", dataProvider = "queryTypeProvider", dataProviderClass = RestDataProvider.class)
	public void testQuery(final TestArgs provider) {
		RestService service = new RestService();
		service.getWithMatcher(provider.getHeaders(), provider.getTarget(), provider.getStatusCode(),
				provider.getMatcher());
		rateLimit(1L);
	}
	
	/**
	 * Query Random authors
	 * @param provider
	 */
	@Test(description = "Test GET Query Authors", dataProvider = "queryAuthorsProvider", dataProviderClass = RestDataProvider.class)
	public void testQueryAuthors(final TestArgs provider) {
		RestService service = new RestService();
		service.setBaseUrl("https://openlibrary.org");
		service.setPort(443);
		service.getWithMatcher(provider.getHeaders(), provider.getTarget(), provider.getStatusCode(),
				provider.getMatcher());
		rateLimit(1L);
	}

	/**
	 * This test uses SSL to fetch books in JSON format.  Note the ease in which SSL is exposed.
	 * @param provider The TestArgs object used to populate the test
	 */
	@Test(description = "Test Get Books", dataProvider = "getBookProvider", dataProviderClass = RestDataProvider.class)
	public void testBooks(final TestArgs provider) {
		RestService service = new RestService();
		service.setBaseUrl("https://openlibrary.org");
		service.setPort(443);
		service.getWithMatcher(provider.getHeaders(), provider.getTarget(), provider.getStatusCode(),
				provider.getMatcher());
		rateLimit(1L);
	}

	/**
	 * This test uses SSL to fetch books in RDF format.
	 * @param provider The TestArgs object used to populate the test
	 */
	@Test(description = "Test Get Books in RDF format", dataProvider = "getRdfBookProvider", dataProviderClass = RestDataProvider.class)
	public void testRdfBooks(final TestArgs provider) {
		RestService service = new RestService();
		service.setBaseUrl("https://openlibrary.org");
		service.setPort(443);
		service.getWithMatcher(provider.getHeaders(), provider.getTarget(), provider.getStatusCode(),
				provider.getMatcher());
		rateLimit(1L);
	}
	
	private void rateLimit(final long seconds) {
		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
