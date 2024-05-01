package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;

public class CucumberAnnotations {
@Before
public void init() {
	RestAssured.baseURI = "https://dev164407.service-now.com/api/now/table/incident";
	RestAssured.authentication = RestAssured.basic("admin", "rB4wB/4BsHa@");
}
@After
public void tearDown(Scenario sc) {
	System.out.println(sc.getName()+" : "+sc.getStatus());

}
}
