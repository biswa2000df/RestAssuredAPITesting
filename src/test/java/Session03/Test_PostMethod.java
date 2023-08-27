package Session03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PostMethod {
	
	@Test
	public void test03() {	
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "kanha");
		jsonObject.put("job", "QA");
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		RestAssured.given().header("Content-type","application/json").
		contentType(ContentType.JSON).
		body(jsonObject.toJSONString()).
		when().post().
		then().statusCode(201).log().all();  //log().all()  this keyword ra kama hauchi console re print kariba jou ta tame post karucha
		
		
	}
	/*{
    "name": "kanha",
    "job": "QA",
    "id": "295",
    "createdAt": "2023-08-21T17:39:05.335Z"
}*/

}
