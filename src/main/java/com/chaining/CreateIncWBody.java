package com.chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncWBody extends Base{
	@Test
	public void createIncWBody() {
		
		RestAssured.baseURI = "https://dev164407.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "rB4wB/4BsHa@");
		Response post = RestAssured.given()
				.contentType(ContentType.JSON)
				.log()
				.all()
				.body("{\"short_description\": \"Incident Created for Chaining.. (:-\",\"description\": \"Post test for Chainingt....\"}").post();
		System.out.println("Status Code :"+post.statusCode());
		post.then().log().all();
		//System.out.println("prettyPrint() :"+post.prettyPrint());
		IncSys_Id = post.jsonPath().get("result.sys_id");
		System.out.println("With help of jsonPath() we are getting values from response :"+IncSys_Id);
		System.out.println(post.jsonPath().get("result.short_description"));
	}
}
