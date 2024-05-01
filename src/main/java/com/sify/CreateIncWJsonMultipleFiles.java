package com.sify;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncWJsonMultipleFiles {
	@DataProvider(name="fetchdata")
	public String[] getData() {
		String[] data = new String[2];
		data[0] = "./data/createInc1.json";
		data[1] = "./data/createInc2.json";
		return data;
	}

	@Test(dataProvider="fetchdata")
	public void createIncWithOutBody(String file) {

		RestAssured.baseURI = "https://dev164407.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "rB4wB/4BsHa@");
		Response post = RestAssured.given().contentType(ContentType.JSON).log().all()
				.body(new File(file)).post();
		System.out.println("Status Code :" + post.statusCode());
		post.then().log().all();

		String resp = post.jsonPath().get("result.sys_id");
		System.out.println("With help of jsonPath() we are getting values from response :" + resp);
		System.out.println(post.jsonPath().get("result.short_description"));
	}
}
