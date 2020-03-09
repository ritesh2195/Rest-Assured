  package APIPack;

	import org.testng.Assert;
	import org.testng.annotations.Test;
	import io.restassured.RestAssured;
	import io.restassured.http.Method;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
	
	public class GET_REQUEST2 {
		
	   @Test
	   public void getWeatherDetails() {
		   
	   RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";  
	   
       RequestSpecification httpRequest= RestAssured.given();
       
       Response response=httpRequest.request(Method.GET, "/Hyderabad");
       
       String responseBody=response.getBody().asString();
       
       System.out.println("Response Body is: "+responseBody);
       
       int expectedStatusCode= response.getStatusCode();
       
       int actualStatusCode=200;
       
       Assert.assertEquals(actualStatusCode, expectedStatusCode);
       
       String statusLine=response.getStatusLine();
       
       Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	   
   }

}
