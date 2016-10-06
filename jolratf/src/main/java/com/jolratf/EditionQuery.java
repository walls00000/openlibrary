package com.jolratf;

import org.testng.annotations.Test;

public class EditionQuery {

	@Test(description = "Test Query on edition", dataProvider = "queryTypeProvider", dataProviderClass = RestDataProvider.class)
	public void TestEdition(final GetProvider provider) {
		RestService service = new RestService();
		final Object obj = service.getWithMatcher(
				provider.getHeaders(), 
				provider.getTarget(), 
				provider.getStatusCode(), 
				provider.getMatcher());
		try {
			//Rate limit
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(description = "Test Get Books", dataProvider = "getBookProvider", dataProviderClass = RestDataProvider.class)
	public void TestBooks(final GetProvider provider) {
		RestService service = new RestService();
		service.setBaseUrl("https://openlibrary.org");
		service.setPort(443);
		final Object obj = service.getWithMatcher(
				provider.getHeaders(), 
				provider.getTarget(), 
				provider.getStatusCode(), 
				provider.getMatcher());
		try {
			//Rate limit
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(description = "Test Get Books in RDF format", dataProvider = "getRdfBookProvider", dataProviderClass = RestDataProvider.class)
	public void TestRdfBooks(final GetProvider provider) {
		RestService service = new RestService();
		service.setBaseUrl("https://openlibrary.org");
		service.setPort(443);
		final Object obj = service.getWithMatcher(
				provider.getHeaders(), 
				provider.getTarget(), 
				provider.getStatusCode(), 
				provider.getMatcher());
		try {
			//Rate limit
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
