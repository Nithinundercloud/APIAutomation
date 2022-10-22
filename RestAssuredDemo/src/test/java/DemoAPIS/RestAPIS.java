package DemoAPIS;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPIS {
	
	
	@Test
	public void asserresponse() {
		RestAssured.baseURI = "http://api.weatherstack.com/";
		
		RequestSpecification request = RestAssured.given();
		
		Response res = request.given().get("current?access_key=09deee9e474df8454173d53df36363c3&query=New York");
		System.out.println(res.getStatusCode());
		
		JsonPath jpath = res.jsonPath();
		Assert.assertEquals(jpath.getString("current.temperature"), "233");
		
		
		
	}
	

}
