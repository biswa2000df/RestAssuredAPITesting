package Session03;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*; //import io.restassured.RestAssured; ae jagare jadi static lekhiba then sabuthire au RestAssured class lekhibaku padibani
import io.restassured.response.Response;

public class Test_GetMethod1 {

	@Test
	public void test01() {
//		Response res = RestAssured.get("https://reqres.in/api/users?page=2");  change import static and * please check both class getmethod1 and getmethod

		Response res = get("https://reqres.in/api/users?page=2");
		// code, body, header, time
		System.out.println("Response code = " + res.getStatusCode());
		System.out.println("The body are = " + res.asPrettyString());
		System.out.println("Response Header = " + res.getHeader("Content-Type"));
		System.out.println("Response Time = " + res.getTime());

		// validate status code
		int exceptedstatuscode = 200;
		int actualstatuscode = res.getStatusCode();

		Assert.assertEquals(exceptedstatuscode, actualstatuscode);
	}

	@Test
	public void test02() {

		// given, when, then BDD Format

//		RestAssured.baseURI = "https://reqres.in/api/users"; //normat class use like RestAssured
		baseURI = "https://reqres.in/api/users"; // for static import
//		RestAssured.given().queryParam("page", "2").when().get().then().statusCode(200);  // this type also you can write 
//		RestAssured.given()  //for static import
		given()
		.queryParam("page", "2")
		.when().get()
		.then().statusCode(200);

	}

}
