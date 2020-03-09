  package APIPack;

	import org.json.simple.JSONObject;
	import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
	import io.restassured.http.Method;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
	
	public class POST_REQUEST {
		
	@Test	
	public void registerCustomer() {
		
	RestAssured.baseURI="http://restapi.demoqa.com/customer";
	
	RequestSpecification httpRequest=RestAssured.given();
	
	JSONObject requestParams=new JSONObject();
	
	requestParams.put("FirstName","buchiyamn");
	
	requestParams.put("LastName","mishra");
	
    requestParams.put("UserName","bucbnhiya");
	  
	requestParams.put("Password","hgdyfghsnbbbnhgggg");
	  
	requestParams.put("Email","bbvuchiya@gmail.com");
	
	httpRequest.header("Content-Type", "application/json");
	
	httpRequest.body(requestParams.toJSONString());
	
	Response response=httpRequest.request(Method.POST, "/register");
	
	String responseBody=response.getBody().asString();
	
	System.out.println("Response Body is:" +responseBody);
	  
	int statusCode=response.getStatusCode();
	  
	System.out.println("Status code is: "+statusCode);
	  
	Assert.assertEquals(statusCode, 201);
	  
	String successCode=response.jsonPath().get("SuccessCode");
	  
	Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	
		
	}
	
	}
