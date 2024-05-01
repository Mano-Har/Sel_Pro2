package com.mock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class learnTemplate {

	@Test
	public void createIncWithOutBody() {
		
		RestAssured.baseURI = "http://localhost:8080/api/now/table/incident";
		//RestAssured.authentication = RestAssured.basic("admin", "rB4wB/4BsHa@");
		Response post = RestAssured.given()
				.queryParam("course_name", "Rest API")
				.queryParam("type", "Online").contentType(ContentType.JSON).get();
		System.out.println("Status Code :"+post.statusCode());
		System.out.println("prettyPrint() :"+post.prettyPrint());
		//String  resp = post.jsonPath().get("result.sys_id");
		//System.out.println("With help of jsonPath() we are getting values from response :"+resp);
	}
}
