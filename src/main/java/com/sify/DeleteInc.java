package com.sify;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteInc {
	@Test
	public void createIncWithOutBody() {
		
		RestAssured.baseURI = "https://dev164407.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "rB4wB/4BsHa@");
		Response post = RestAssured.given()
				.contentType(ContentType.JSON)
				.log()
				.all()
				.patch("ca916ad597813110426bf896f053af30");
		System.out.println("Status Code :"+post.statusCode());
		post.then().log().all();
		//System.out.println("prettyPrint() :"+post.prettyPrint());
		String  resp = post.jsonPath().get("result.sys_id");
		System.out.println("With help of jsonPath() we are getting values from response :"+resp);
		System.out.println(post.jsonPath().get("result.short_description"));
	}
}
