package com.sify;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncWoBody {
	@Test
	public void createIncWithOutBody() {
		
		RestAssured.baseURI = "https://dev164407.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "rB4wB/4BsHa@");
		Response post = RestAssured.given().contentType(ContentType.JSON).post();
		System.out.println("Status Code :"+post.statusCode());
		System.out.println("All Response :"+post);
		System.out.println("prettyPrint() :"+post.prettyPrint());
		String  resp = post.jsonPath().get("result.sys_id");
		System.out.println("With help of jsonPath() we are getting values from response :"+resp);
	}
}
