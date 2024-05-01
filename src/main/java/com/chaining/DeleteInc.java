package com.chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteInc extends Base{
	@Test(dependsOnMethods= {"com.chaining.CreateIncWBody.createIncWBody"})
	public void deleteInc() {
		
		RestAssured.baseURI = "https://dev164407.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "rB4wB/4BsHa@");
		Response post = RestAssured.given()
				.contentType(ContentType.JSON)
				.log()
				.all()
				.delete(IncSys_Id);
		System.out.println("Status Code :"+post.statusCode());
		post.then().log().all();
		
	}
}
