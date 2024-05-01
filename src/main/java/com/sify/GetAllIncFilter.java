package com.sify;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllIncFilter {

	@Test
	public void getInc() {
		//Add EndPoint
		RestAssured.baseURI="https://dev164407.service-now.com/api/now/table/incident";
		
		
		//Add Header
		RestAssured.authentication  = RestAssured.basic("admin", "rB4wB/4BsHa@");
		
		//Send Request 
		//RequestSpecification queryParam = RestAssured.given().queryParam("sysparm_fields", "sys_id,number,short_description,description");
		RequestSpecification queryParam = RestAssured.given().queryParam("sysparm_fields", "sys_id,short_description");
		
		Response response = queryParam.get();
		//Response response = RestAssured.get();
		//Validate Response
		System.out.println(response.prettyPrint());
		System.out.println("Status Code :: "+response.statusCode());
	}
}
