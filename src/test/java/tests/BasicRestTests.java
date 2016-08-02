package tests;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class BasicRestTests {
	final static String authKey = "Basic bXlrb2xhLmdsYWRjaGVua29AZ21haWwuY29tOlBAc3N3b3JkMTIz";


	@BeforeTest
	public void before () {
		RestAssured.baseURI = "https://mhladchenko.testrail.net";
		RestAssured.requestContentType(ContentType.JSON);
		//RestAssured.authentication = basic("mykola.gladchenko@gmail.com","P@ssword123");

	}

	@Test
	public void successfulGetCaseResponseCode1(){
		int testCaseId = 1;
		Response response = given().header("Authorization", authKey)
				.when().get("/index.php?/api/v2/get_case/{t}",testCaseId);
		String testCaseTitle = "Verify successful user login";
		Assert.assertTrue(response.asString().contains(testCaseTitle), "Test case title not found in output");
		Assert.assertEquals(200, response.getStatusCode(), "Status code is wrong");
	}

	@Test
	public void successfulGetCaseResponseCode2(){
		given()
				.header("Authorization", authKey)
				.expect()
				.statusCode(200)
				.response()
				.when()
				.get("/index.php?/api/v2/get_case/1");
	}

}
