package _01_com.masteringrestassured.api.tests.get;
import java.util.List;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class _02_Get_Request_Extract_Node_Text_Using_JsonPath_Class 
{
	@Test
	public void getUserIdAssociatedPosts_AndValidateNoRangeOfTheReturnedPostIds() throws Exception 
	{   	
		// Base URL of the RESTful web service
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

		RequestSpecification httpRequest = RestAssured.given();

		/* Make a request to the server by specifying the method Type and the method URL,
		   and assign the Response from the server to an object reference variable */
		Response response = httpRequest.request(Method.GET, "/posts?userId=2");

		// Get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Query the JsonPath object to get a List element of type String based on the input
		List<Integer> postIds = jsonPathEvaluator.get("id");

		for (Integer obj : postIds) 
		{               
			if ( (obj <= 0) || ( obj > 100) )
				throw new IndexOutOfBoundsException("Post Id " + obj + 
						" was encountered which is not within range");        
		}
	}	
}