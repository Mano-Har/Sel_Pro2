package com.sify;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetIncWithMultiFilterViaXml {

	@Test
	public void getInc() {
		//Add EndPoint
		RestAssured.baseURI="https://dev164407.service-now.com/api/now/table/incident";
		
		
		//Add Header
		RestAssured.authentication  = RestAssured.basic("admin", "rB4wB/4BsHa@");
		
		//Send Request        / Single Param \
		 /* RequestSpecification queryParam = RestAssured.given().queryParam("sysparm_fields", "sys_id,number,short_description,description");
	    
		RequestSpecification queryParam = RestAssured.given().queryParam("sysparm_fields", "sys_id,number"); */
		
		
		/* Multi  Param */
		
		Map<String ,String > mp=new HashMap<String ,String>();
		mp.put("sysparm_fields", "sys_id,short_description");
		mp.put("category", "software");
		
		Response response = RestAssured.given().queryParams(mp).accept(ContentType.XML).get();
		List<Object> list = response.xmlPath().getList("response.result.sys_id");
		System.out.println("All Sys Id >"+list);
		for(Object l :list) {
			System.out.println((String)l);
		}
		
		
		//Validate Response
		System.out.println("-------------------------------");
		System.out.println(response.prettyPrint());
		System.out.println("Status Code :: "+response.statusCode());
	}
}
