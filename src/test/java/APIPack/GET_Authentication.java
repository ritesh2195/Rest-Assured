  package APIPack;

  import org.testng.Assert;
  import org.testng.annotations.Test;
  import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
  import io.restassured.response.Response;
  import io.restassured.specification.RequestSpecification;
	

  public class GET_Authentication {
  	
	@Test	
  	public void authenticationTest() {
  		
    RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";  
		   
	RequestSpecification httpRequest= RestAssured.given();
	
	PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
	
	auth.setUserName("ToolsQA");
	
	auth.setPassword("TestPassword");
	
	RestAssured.authentication=auth;
	       
	Response response=httpRequest.request(Method.GET, "/");
	       
	String responseBody=response.getBody().asString();
	       
	System.out.println("Response Body is: "+responseBody);
	       
	int expectedStatusCode= response.getStatusCode();
	       
	int actualStatusCode=200;
	       
    Assert.assertEquals(actualStatusCode, expectedStatusCode);
	       
	String statusLine=response.getStatusLine();
	       
	Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");	
  		
  	}

}
