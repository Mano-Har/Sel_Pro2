package com.sify;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetIncidentWithValidation {

	@Test
	public void getInc() {
		        // Add EndPoint
				RestAssured.baseURI = "https://dev164407.service-now.com/api/now/table/incident";

				// Add Header
				RestAssured.authentication = RestAssured.basic("admin", "rB4wB/4BsHa@");

				// Send Request
				Response response = RestAssured.get().then().assertThat().statusCode(200).contentType(ContentType.JSON)
						.extract().response();

				// Validate Response
				System.out.println(response.prettyPrint());
				System.out.println("Status Code :: " + response.statusCode());
	}
}
