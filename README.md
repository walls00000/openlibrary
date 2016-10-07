Java Open Library RESTful API Testing Framework (JOLRATF)
=========================================================

The Java Open Library RESTful API Testing Framework is a flexible framework for testing APIs.  Its strength is in its ability to help the engineer with tools to manipulate URLs headers, and ample flexibility for verification.  Built-in to this framework is hamcrest matchers, jackson FasterXML package for mapping Pojos, TestNG for flexible data provider functionality, and more.  My goal is to show how a well designed framework can aid in the testing of REST APIs so that the test writer does not need to worry about the framework or the client as this feature rich framework has much to offer.

The JOLRATF has its strengths in verification where hamcrest matchers can be used for quick and easy matching to verify content exists in a response.  For this functionality, please see the queryTypeProvider and getBooksProvider in the org.testng.annotations.DataProvider class. Additionally with the jacksonSamleSimplePojoMapper, deserializing objects is made easier and integrated into a dataprovider.  For this functionality, see the Author.java class and its corresponding data provider: org.testng.annotations.DataProvider.getAuthorProvider.  With the use of dataproviders and a TestArgs object and corresponding builder, creating data-driven tests with verification mapped into the test, makes writing tests quicker.

The openlibrary is a set of APIs with many permutations.  That said, there are many additional areas of testing which are not addressed by this tester in its current state. This tester has the ability to do the following, but examples are not provided to do so given the time constraint:

* Header testing
* authentication
* Performing negative testing 
* Other REST methods
* execute a PUT, POST PATCH, DELETE for a GET API
* cookies
* performance

GETTING STARTED
---------------
This project was build with maven and eclipse, so the instructions are for this environment only.
* Obtain and install eclipse for java http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/marsr
* Install the TestNG Plugin http://testng.org/doc/eclipse.html
* On the commandline, navigate to the jolratf directory and run mvn eclipse:eclipse
* Import the jolratf project into eclipse using File=>Import=>Existing Maven Projects
  *Browse to the jolratf directory, select it, and click finish
*The jolratf project should be imported into eclipse.


RUNNING TESTS
-------------

Running tests is done with the TestNG plugin.  With this plugin installed, do the following but if you encounter any problems, please refer to the TestNG website located here: http://testng.org/doc/eclipse.html

The following proceedure will run the tests in jolratf.  All tests have been rate-limited with 1 second between tests. There are no destructive tests at this time.

1. Navigate to the FunctionalTest.java TestClass in the Package Explorer
2. Right-Click on the FunctionalTest.java and select "Run As", and select "TestNG Test" in the drop-down.  If this option is not there, please revisit the installation of the TestNG plugin under GETTING STARTED.
3. The tests log to standard output, and are quite verbose, showing the complete response for each REST call.
4. When the tests complete, a summary of results are logged at the end of the output, but it is better to view results in the TestNG "Results of running class FunctionalTest" where details of failed tests can be seen by clicking on failed tests.  Note the detail of failed testAuthor tests.
5. Enjoy the tester.





RESEARCH
--------
Testing tools
-------------
This is a list of tools I started out with in my quest to create a REST API framework in Java. 

  * REST Client for Chrome: http://chromerestclient.appspot.com/
  * Burp Suite https://portswigger.net/burp/
  * TestNG 
    1. http://testng.org/doc/eclipse.html#eclipse-create-launch
    2. http://testng.org/doc/index.html
  * POJO Mapper https://github.com/FasterXML/jackson-docs/wiki/JacksonSampleSimplePojoMapper
  * Rest Assured framework 
    1. https://github.com/rest-assured/rest-assured
    2. https://github.com/rest-assured/rest-assured/wiki/Usage
    3. http://testdetective.com/rest-assured-framework-overview/ 
    4. http://testdetective.com/rest-assured-going-deeper/
  * Jersy Test Framework https://jersey.java.net/documentation/latest/test-framework.html

Response Verification 
---------------------

  * with unitils reflection Assert http://unitils.org/tutorial-reflectionassert.html
  * with shazamcrest bean comparison https://github.com/shazam/shazamcrest
  * with json-schema-validator https://mvnrepository.com/artifact/com.jayway.restassured/json-schema-validator/2.2.0
