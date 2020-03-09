  package APIPack;

	import org.junit.Assert;
	import org.testng.annotations.Test;
	import io.restassured.RestAssured;
	import io.restassured.http.Method;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class GET_Validate_JSON_BODY {
		
		@Test	
		public void GetWeatherDetails() {
			
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET, "/Hyderabad");
		
		String responseBody=response.getBody().asString();
		
		System.out.println("Response body is "+responseBody);
		
		Assert.assertEquals(responseBody.contains("Hyderabad"), true);
				
		
		}
	
	}
