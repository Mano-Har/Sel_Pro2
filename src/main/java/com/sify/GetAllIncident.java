package com.sify;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncident {

	@Test
	public void getInc() {
		//Add EndPoint
		RestAssured.baseURI="https://dev164407.service-now.com/api/now/table/incident";
		
		
		//Add Header
		RestAssured.authentication  = RestAssured.basic("admin", "rB4wB/4BsHa@");
		
		//Send Request 
		Response response = RestAssured.get();
		
		//Validate Response
		System.out.println(response.prettyPrint());
		System.out.println("Status Code :: "+response.statusCode());
		
		
	}
}
