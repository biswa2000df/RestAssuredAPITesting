package Session04;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CheckForValidResponse {

	@Test
	public void getSingleUser() {

		RestAssured.baseURI = "https://reqres.in/api/users/2";

		// Get Request specification of the Request
		RequestSpecification requestSpec = RestAssured.given();

		// call the get request
		Response response = requestSpec.get();

		// get responsecode
		int statusCode = response.getStatusCode();
		
		System.out.println(response.getBody().asPrettyString());

		// validate actual status code to the excepted code
		Assert.assertEquals(statusCode, 200);
	}

}
