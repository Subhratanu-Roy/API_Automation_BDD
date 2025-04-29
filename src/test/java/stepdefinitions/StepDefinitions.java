package stepdefinitions;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.User;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinitions extends Utils {

	RequestSpecification reqSpec;
	Response response;
	ResponseSpecification resSpec;
	
	public StepDefinitions() throws IOException { 
		reqSpec = given().spec(requestSpecification()).header("x-api-key","reqres-free-v1");
		resSpec = new ResponseSpecBuilder().expectStatusCode(201).expectContentType(ContentType.JSON).build();
	} 
 

	@Given("Add User payload with {string}, {string}")
	public void add_user_payload(String name, String job) throws IOException {
		
		ObjectMapper om = new ObjectMapper();
		String userBody = om.writeValueAsString(TestDataBuild.addUserPayload(name, job));
		reqSpec.body(userBody).log().all();				
		
	} 

	@When("User calls {string} with {string} request method")
	public void user_calls_with_request_method(String resource, String method) {
		APIResources resourceAPI = APIResources.valueOf(resource);
		System.out.println("resource: "+resourceAPI.getResource());
		switch (method) {
		case "POST": 
			response = reqSpec.post(resourceAPI.getResource());
			break;
		case "GET": 
			System.out.println("Enter into get");
			//response = res.when().get("/api/users/2").then().log().all().extract().response();
			response = reqSpec.get(resourceAPI.getResource());
			break;
		case "PUT":
			response = reqSpec.put(resourceAPI.getResource());
			break;
		case "DELETE":
			System.out.println("Enter into delete");
			response = reqSpec.when().delete(resourceAPI.getResource());
			break;
		default:
			System.out.println("Not a valid method");

		}
		
	

	}

	@Then("API call got success with status code {int}")
	public void api_call_got_success_with_status_code(int status) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), status);
	}

	@And("{string} in response body is {string}")
	public void job_in_response_body_is(String string, String string2) {
		// Write code here that turns the phrase above into concrete actions
		JsonPath jp = new JsonPath(response.asString());
		String data = jp.getString(string);
		System.out.println(data);
		assertEquals(data, string2);
	}
	
	@Given("login user payload with {string} and {string}")
	public void login_user_payload(String email, String password) throws JsonProcessingException {
		
		ObjectMapper om = new ObjectMapper();
		String loginPayload = om.writeValueAsString(TestDataBuild.loginPayload(email, password));
		reqSpec.body(loginPayload).log().all();
		
		
	}
	@Given("register user payload with {string} and {string}")
	public void register_user_payload_with_and(String string, String string2) throws JsonProcessingException {
	 ObjectMapper om = new ObjectMapper();
	 String registerPayload = om.writeValueAsString(TestDataBuild.loginPayload(string, string2));
	 reqSpec.body(registerPayload).log().all();
		
	}
	

}
