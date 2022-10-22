package DemoAPIS;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestOne {

	@BeforeTest
	public void loadurl() {
		baseURI="https://reqres.in/";
	}

	@Test
	public void testone() {
		//get("api/users?page={number}",2).then().statusCode(200).body("data[1].id",equalTo(8)).log().all();
		

	}

	@Test
	public void testtwo() {
		
		when().
		get("api/users?page={number}",2).then().
		body("data.findAll {it.id < 11}.first_name",hasItems("Byron"));
	}

	@Test
	public void testthree() {
		
		Response resposne = given().body("{ \"name\" : \"Job\", \"job\" : \"jobless\"}").when().post("api/users");	
		JsonPath js = resposne.jsonPath();
		System.out.println(resposne.asString());
		System.out.println(js.getInt("id"));
	}
}
