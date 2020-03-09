  package APIPack;

	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	
	import io.restassured.RestAssured;
	import io.restassured.http.Method;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
    	
	public class GET_Single_Employee_Record  {
  		
  	RequestSpecification httpRequest;
  	Response response;
  	
  	@BeforeClass
  	public void getEmployeeData() throws InterruptedException {
  		
  	//logger.info(" employee test started");
  	
  	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
    
    httpRequest=RestAssured.given();
    
    response=httpRequest.request(Method.GET, "/employees/");
    
    Thread.sleep(3000);
  		
  	}

  	@Test
  	public void checkResponseBody() {
  		    
  	String responseBody=response.getBody().asString();
  	  
  	//Assert.assertEquals(responseBody.contains(empID), true);
}
  	@Test
  	public void statusCode() {
  		
  	int statusCode=response.getStatusCode();
  	 
    Assert.assertEquals(statusCode, 200);	
  			
  	}
  	
  	 @Test
  	 public void checkResponseTime() {
  		   
  	 long responseTime=response.getTime();
  	  	  
  	 Assert.assertTrue(responseTime<6000);
  		  
  	  }	
  	 
  	 @Test 
  	 public void checkStatusLine() {
  		   
  	 String statusLine=response.getStatusLine();
  	  
  	 Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
}
  	@Test
    public void checkContentType() {
  	  
    String contentType=response.getContentType();
    
    Assert.assertEquals(contentType, "text/html;charset=UTF-8");
  	  
    } 
  	 
  	@Test
    public void checkServerType() {
  	  
    String serverType=response.getHeader("Server");
    
    Assert.assertEquals(serverType, "nginx/1.16.0");
  	  
    }
  	
  	@Test
    public void  checkContentLength() {
  		
  	String contentLength=response.getHeader("Content-Length");
  	
  	Assert.assertTrue(Integer.parseInt(contentLength)<1500);
  		
  	} 
  	
  	@AfterClass
    public void tearDown() {
  	  
    //logger.info("test is completed");  
  	  
    }
	}