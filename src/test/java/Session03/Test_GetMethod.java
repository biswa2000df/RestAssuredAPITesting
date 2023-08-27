package Session03;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Test_GetMethod {

	@Test
	public void test01() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		// code, body, header, time
		System.out.println("Response code = " + res.getStatusCode());
		System.out.println("The body are = " + res.asPrettyString());
		System.out.println("Response Header = " + res.getHeader("Content-Type"));
		System.out.println("Response Time = " + res.getTime());
		
		
		//validate status code
		int exceptedstatuscode = 200;
		int actualstatuscode = res.getStatusCode();
		
		Assert.assertEquals(exceptedstatuscode, actualstatuscode);
	}
	
	@Test
	public void test02() {
		
		//given, when, then BDD Format
		
		RestAssured.baseURI = "https://reqres.in/api/users";
//		RestAssured.given().queryParam("page", "2").when().get().then().statusCode(200);  // this type also you can write 
		RestAssured.given()
		.queryParam("page", "2")
		.when().get()
		.then().statusCode(200);

	}

}
