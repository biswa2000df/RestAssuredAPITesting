package Session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PatchMethod {
	
	@Test
	public void test05() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "mama");
		jsonObject.put("job", "tester");

		RestAssured.baseURI = "https://reqres.in/api/users/295"; // jou 295 ta lekha haeichi saeta hauchi id . post kala
																	// bele jou id generate haethaee sae id use kariki
																	// update karajae
		
		RestAssured.given().
			header("Content-type", "application/json").
			contentType(ContentType.JSON).
			body(jsonObject.toJSONString()).
		when()
			.patch().
		then()
			.statusCode(200)
			.log().all(); // log().all() this
																									// keyword ra kama
																									// hauchi console re
																									// print kariba jou
																									// ta tame post
																									// karucha

	}

	/*{
    "name": "mama",
    "job": "tester",
    "updatedAt": "2023-08-21T17:40:13.595Z"
}*/

}
