package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IncidentManagement {
public Response response;
	@Given("Set End Point")
	public void initilizeEndPoint() {
		RestAssured.baseURI = "https://dev164407.service-now.com/api/now/table/incident";
	}
	@And("Set up Basic Auth")
	public void basicAuth() {
		RestAssured.authentication = RestAssured.basic("admin", "rB4wB/4BsHa@");
	}
	@When("Place the Post Request")
	public void sendPostRequest() {
		 response = RestAssured.given()
				.contentType(ContentType.JSON)
				.log()
				.all()
				.body("{\"short_description\": \"Incident Created via Cucumber 3 (:-\",\"description\": \"Post test through Cucumber....3\"}")
				.post();
	}
	
	@When("Send the Post Request with body as {string} and {string}")
	public void sendPostRequestwithbody(String ShortDes, String Descrip) {
		 response = RestAssured.given()
				.contentType(ContentType.JSON)
				.log()
				.all()
				.body("{\"short_description\": \""+ShortDes+"\",\"description\": \""+Descrip+"\"}")
				.post();
	}
	@Then("Verify the status code as (.*)$")
	//@Then("Verify the status code as {int}")
	public void verifyStatusCode(String code) {
		response.then()
		.statusCode(Integer.parseInt(code))
		.extract()
		.response();
	}
	@And("Verify the response body contains contentType as (.*)$")
	public void verifyContentType(String type) {
		if(type.contains("json")) {
		response.then()
		.contentType(ContentType.JSON)
		.extract()
		.response();
		System.out.println(response.jsonPath().get("result.short_description"));
		System.out.println(response.jsonPath().get("result.description"));
		System.out.println(response.jsonPath().get("result.sys_id"));
		}else if(type.contains("xml")) {
			response.then()
			.contentType(ContentType.XML)
			.extract()
			.response();
		}else {
			throw new RuntimeException();
		}
	}
}
