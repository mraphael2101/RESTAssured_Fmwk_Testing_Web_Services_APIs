package _01_com.masteringrestassured.api.tests.get;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class _01_Get_Random_UserId_And_Print_Out_Email_Address 
{ 
	
	@Test
	public void getRandomUserIdAndPrintOutEmailAddress() throws Exception
	{   	
		/* Base URL of the RESTful web service */
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
 
		/* Get the RequestSpecification of the request that you want to send
		   to the server. The server is specified by the BaseURI provided in 
		   the previous step. given() allows you to specify how the requst 
		   will look like e.g. the parameters */
		RequestSpecification httpRequest = RestAssured.given();
 
		/* Make a request to the server by specifying the method Type and the method URL,
		   and assign the Response from the server to an object reference variable */
		Response response = httpRequest.request(Method.GET, "/users?id=2");
 		
		/* Get the JsonPath object instance from the Response interface */
		JsonPath jsonPathEvaluator = response.jsonPath();
	 
		/* Query the JsonPath object to get a List element of type String based on 
		   the input */
		List<String> email = jsonPathEvaluator.get("email");
	 
		System.out.println("email " + email.get(0)); 
	}

}