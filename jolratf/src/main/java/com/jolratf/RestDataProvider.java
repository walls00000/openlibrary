package com.jolratf;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.testng.annotations.DataProvider;

import com.jolratf.json.Author;

public class RestDataProvider {

	/**
	 * This data provider tests the /authors/XXX.json path.  Because it is using deserialization 
	 * for verification, this test in its current form shows three failures.  The failure 
	 * messages are explicit because of the handling of the deserialization with the POJO object.
	 * @return a multi-dimentional array of objects
	 */
	@DataProvider(name = "getAuthorProvider")
	public static Object[][] getAuthorProvider() {
		final Map<String, String> headers = new HashMap<String, String>();
		headers.put("accept", "application/json");
		headers.put("accept-encoding", "gzip, deflate");
		headers.put("user-agent", "jolratf");
		Random random = new Random(); //Add randomness since there is such a large number of authors
		return new Object[][] {
				// Header, Target, StatusCode, Pojo
				{ TestArgs.builder().headers(headers).target("/authors/OL1A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL2A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL3A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL4A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL5A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL6A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL7A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL8A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL9A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL10A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL100A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL1000A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL10000A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL100000A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL1000000A.json").statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target("/authors/OL10000000A.json").statusCode(404).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target(String.format("/authors/OL%dA.json", random.nextInt(1000000))).statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target(String.format("/authors/OL%dA.json", random.nextInt(1000000))).statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target(String.format("/authors/OL%dA.json", random.nextInt(1000000))).statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target(String.format("/authors/OL%dA.json", random.nextInt(1000000))).statusCode(200).pojo(Author.class).build() },
				{ TestArgs.builder().headers(headers).target(String.format("/authors/OL%dA.json", random.nextInt(1000000))).statusCode(200).pojo(Author.class).build() },
		};
	}

	/**
	 * This data provider implements the hamcrest matcher to verify the response contains certain elements.  
	 * While it is not verifying the form of the response, the hamcrest matchers provide a quick and accurate 
	 * implementation for matching.
	 * @return
	 */
	@DataProvider(name = "queryTypeProvider")
	public static Object[][] queryTypeProvider() {
		final Map<String, String> headers = new HashMap<String, String>();
		headers.put("accept", "application/json");
		headers.put("accept-encoding", "gzip, deflate");
		headers.put("user-agent", "jolratf");
		Random random = new Random();
		return new Object[][] {	
			// Header, Target, StatusCode, Matcher, Matchers
				{ TestArgs.builder().headers(headers).target("/query.json?type=/type/edition").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433363M"))
						.additionalMatchers(org.hamcrest.Matchers.containsString("/books/OL25433364M"),
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
								org.hamcrest.Matchers.containsString("/books/OL6032869M"))
						.build() }, 
						};
	}
	
	/**
	 * A provider to which uses the query API on random authors.
	 * @return
	 */
	@DataProvider(name = "queryAuthorsProvider")
	public static Object[][] queryAuthorsProvider() {
		final Map<String, String> headers = new HashMap<String, String>();
		headers.put("accept", "application/json");
		headers.put("accept-encoding", "gzip, deflate");
		headers.put("user-agent", "jolratf");
		Random random = new Random();
		return new Object[][] {	
			{TestArgs.builder().headers(headers)
				.target(String.format("/query.json?type=/type/edition&authors=/authors/OL%dA&limit=2", random.nextInt(1000000)))
				.statusCode(200).matcher(org.hamcrest.Matchers.containsString("key")).build()},
			{TestArgs.builder().headers(headers)
				.target(String.format("/query.json?type=/type/edition&authors=/authors/OL%dA&limit=2", random.nextInt(1000000)))
				.statusCode(200).matcher(org.hamcrest.Matchers.containsString("key")).build()},
			{TestArgs.builder().headers(headers)
				.target(String.format("/query.json?type=/type/edition&authors=/authors/OL%dA&limit=2", random.nextInt(1000000)))
				.statusCode(200).matcher(org.hamcrest.Matchers.containsString("key")).build()},
			{TestArgs.builder().headers(headers)
				.target(String.format("/query.json?type=/type/edition&authors=/authors/OL%dA&limit=2", random.nextInt(1000000)))
				.statusCode(200).matcher(org.hamcrest.Matchers.containsString("key")).build()},
			{TestArgs.builder().headers(headers)
				.target(String.format("/query.json?type=/type/edition&authors=/authors/OL%dA&limit=2", random.nextInt(1000000)))
				.statusCode(200).matcher(org.hamcrest.Matchers.containsString("key")).build()},
			};
	}

	@DataProvider(name = "getBookProvider")
	public static Object[][] getBookProvider() {
		final Map<String, String> headers = new HashMap<String, String>();
		headers.put("accept", "application/json");
		headers.put("accept-encoding", "gzip, deflate");
		headers.put("user-agent", "jolratf");

		return new Object[][] {
				{ TestArgs.builder().headers(new HashMap<String, String>()).target("/books/OL25433364M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433364M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL21478883M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL21478883M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL25433367M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433367M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL25433368M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433368M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL25433369M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433369M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL25433374M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433374M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL25433378M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433378M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL17910702M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL17910702M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL22691075M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL22691075M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL18497493M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL18497493M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL16241881M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL16241881M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL17860773M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL17860773M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL14825375M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL14825375M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL17210465M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL17210465M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL14825376M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL14825376M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL14825377M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL14825377M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL6034835M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL6034835M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL6036346M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL6036346M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL6032869M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL6032869M")).build() } };

	}

	@DataProvider(name = "getRdfBookProvider")
	public static Object[][] getRdfBookProvider() {
		final Map<String, String> headers = new HashMap<String, String>();
		headers.put("accept", "application/json");
		headers.put("accept-encoding", "gzip, deflate");
		headers.put("user-agent", "jolratf");

		return new Object[][] {
				{ TestArgs.builder().headers(new HashMap<String, String>()).target("/books/OL25433364M").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433364M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL21478883M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL21478883M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL25433367M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433367M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL25433368M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433368M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL25433369M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433369M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL25433374M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433374M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL25433378M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL25433378M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL17910702M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL17910702M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL22691075M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL22691075M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL18497493M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL18497493M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL16241881M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL16241881M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL17860773M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL17860773M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL14825375M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL14825375M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL17210465M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL17210465M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL14825376M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL14825376M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL14825377M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL14825377M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL6034835M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL6034835M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL6036346M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL6036346M")).build() },
				{ TestArgs.builder().headers(headers).target("/books/OL6032869M.rdf").statusCode(200)
						.matcher(org.hamcrest.Matchers.containsString("/books/OL6032869M")).build() } };

	}

}
