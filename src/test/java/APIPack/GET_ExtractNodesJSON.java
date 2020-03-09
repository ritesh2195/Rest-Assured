  package APIPack;

	import org.testng.annotations.Test;
	
	import io.restassured.RestAssured;
	import io.restassured.http.Method;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;

	public class GET_ExtractNodesJSON {
  		
  		@Test	
		public void GetWeatherDetails() {
			
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET, "/Hyderabad");
		
		JsonPath path=response.jsonPath();
		
		System.out.println(path.get("City"));
		
		System.out.println(path.get("Temperature"));
		
		System.out.println(path.get("Humidity"));
		
		System.out.println(path.get("WindSpeed"));
		
  		}
}
