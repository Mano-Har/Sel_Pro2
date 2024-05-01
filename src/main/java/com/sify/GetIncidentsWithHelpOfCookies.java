package com.sify;

import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncidentsWithHelpOfCookies {

	@Test
	public void getInc() {
		//Add EndPoint
		RestAssured.baseURI="https://dev164407.service-now.com/api/now/table/incident";
		//Add Header
		RestAssured.authentication  = RestAssured.basic("admin", "rB4wB/4BsHa@");
		
		//Send Request 
		//Response response = RestAssured.given().cookie("JSESSIONID","65E5249E0C3DC3931330F447C10BF73D").get();
		Response response = RestAssured.get();
		Map<String, String> cookies = response.getCookies();
		for(Entry<String,String> entrySet :cookies.entrySet()) {
			System.out.println("Key "+entrySet.getKey()+" : "+entrySet.getValue());
		}
		
		//Validate Response
		System.out.println("Status Code :: "+response.statusCode());
		//System.out.println(response.prettyPrint());
		
		
	}
}
