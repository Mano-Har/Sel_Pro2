package com.sify;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class CreateIncNdSchemaValidation {
	@Test
	public void createIncWithOutBody() {
		
		RestAssured.baseURI = "https://dev164407.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "rB4wB/4BsHa@");
		Response post = RestAssured.given()
				.contentType(ContentType.JSON)
				.log()
				.all()
				.body("{\"short_description\": \"Incident Created via Script for Schema validator\",\"description\": \"Post test through Script....\"}")
				.post()
				.then()
				.assertThat()
				.body(JsonSchemaValidator.matchesJsonSchema(new File("./data/CreateIncSchema.json")))
				.extract()
				.response();
		System.out.println("Status Code :"+post.statusCode());
		//post.then().log().all();
		post.prettyPrint();
		//System.out.println("prettyPrint() :"+post.prettyPrint());
		String  sysid = post.jsonPath().get("result.sys_id");
		System.out.println("With help of jsonPath() we are getting values from response :"+sysid);
		System.out.println(post.jsonPath().get("result.short_description"));
	}
}
