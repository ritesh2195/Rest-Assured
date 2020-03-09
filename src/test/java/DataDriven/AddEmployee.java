  package DataDriven;

	import java.io.IOException;
	import org.json.simple.JSONObject;
	import org.junit.Assert;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
	import io.restassured.RestAssured;
	import io.restassured.http.Method;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
	
	public class AddEmployee {
	
  	@Test(dataProvider="empData")	
  	public void postNewEmployee(String ename, String eage, String esalary) {
  		
  	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
  	
  	RequestSpecification httpRequest=RestAssured.given();
  	
  	JSONObject requestParams=new JSONObject();
  	
  	requestParams.put("name", ename);
  	
  	requestParams.put("salary", eage);
  	
  	requestParams.put("age", esalary);
  	
  	httpRequest.header("Content-Type", "application/json");
  	
  	httpRequest.body(requestParams.toJSONString());
  	
  	Response response=httpRequest.request(Method.POST, "/create");
  	
  	String responseBody=response.getBody().asString();
  	
  	System.out.println("Response body is "+responseBody);
  	
  	Assert.assertEquals(responseBody.contains(ename), true);
  	
  	Assert.assertEquals(responseBody.contains(eage), true);
  	
  	Assert.assertEquals(responseBody.contains(esalary), true);
  	
  	int statusCode=response.getStatusCode();
  	
  	Assert.assertEquals(statusCode, 200);
  		
  		
  	}
  
  	@DataProvider(name="empData")
  	public String [][] getData() throws IOException {
  		
  	String path="src//test//java//DataDriven//API_DataDriven.xlsx";
  	
    int rows=XLUtil.getRowCount(path, "Sheet1");
  	
    int columns=XLUtil.getCellCount(path, "Sheet1", 1);
    
    String [][] empData=new String [rows][columns];
    
    for(int i=1; i<=rows; i++) {
    	
    for(int j=0; j<columns; j++) {
    	
    	empData[i-1][j]=XLUtil.getCellData(path, "Sheet1", i, j);
    }
    	
    }
  	return empData;	
  	}

}
