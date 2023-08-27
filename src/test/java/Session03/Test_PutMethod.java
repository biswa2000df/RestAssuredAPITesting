package Session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PutMethod {

	@Test
	public void test04() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "maa");
		jsonObject.put("job", "housewife");

		RestAssured.baseURI = "https://reqres.in/api/users/295"; // jou 295 ta lekha haeichi saeta hauchi id . post kala
																	// bele jou id generate haethaee sae id use kariki
																	// update karajae
		
		RestAssured.given().header("Content-type", "application/json").contentType(ContentType.JSON)
				.body(jsonObject.toJSONString()).when().put().then().statusCode(200).log().all(); // log().all() this
																									// keyword ra kama
																									// hauchi console re
																									// print kariba jou
																									// ta tame post
																									// karucha

	}
	/*{
    "name": "maa",
    "job": "housewife",
    "updatedAt": "2023-08-21T17:39:35.090Z"
}*/

}
