package stepDefinition;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;


public class steps {
	String api;
	String baseURI;
	String response, data;

	@Given("API request info")
	public void api_request_info() {
		baseURI = "http://localhost:3000";

		api = "/posts";

		RestAssured.baseURI = baseURI;
		
		data = "{" + 
	    		"\"author\": \"myauthor\"," + 
	    		"\"id\": \"9\"," + 
	    		"\"title\": \"mytitle\"" + 
	    		"}";

	}

	@When("Submit API request")
	public void submit_api_request() {
		response = given().log().all().accept(ContentType.JSON).contentType(ContentType.JSON)
				.body(data).when().post(api).then().assertThat().statusCode(201).body("id", equalTo("9"))
				.header("Content-Type", "application/json; charset=utf-8").extract().response().asString();

	}

	@Then("Validate API results")
	public void validate_api_results() {
		System.out.println(response);

		JsonPath js = new JsonPath(response);
		String placeId = js.getString("id");

		System.out.println("My PlaceId is " + placeId);

	}
}
