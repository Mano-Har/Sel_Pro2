package com.sify;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class CreateIncWithBodyNdHeadersInMap {

	@Test
	public void getInc() {
		//Add EndPoint
		RestAssured.baseURI="https://dev164407.service-now.com/api/now/table/incident";
		
		
		//Add Header
		RestAssured.authentication  = RestAssured.basic("admin", "rB4wB/4BsHa@");
		
		/* Multi  Param */
		
		Map<String ,String > mp=new HashMap<String ,String>();
		mp.put("short_description", "Incident Created via map (:-");
		mp.put("description", "Json map test");
		
		Map<String ,String > headers=new HashMap<String ,String>();
		headers.put("content-type", "application/json");
		headers.put("accept", "application/xml");
		
		Response response = RestAssured.given()
				.headers(headers)
				.log()
				.all()
				.queryParams(mp).post();
		response.then().log().all();

		String resp = response.jsonPath().get("result.sys_id");
		System.out.println(" jsonPath() we are getting values from response :" + resp);
		System.out.println(response.jsonPath().get("result.short_description"));
	}
}
