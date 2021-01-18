package _02_com.masteringrestassured.api.tests.post;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

/* Do a post using the same UserId with a non-empty title and body, verify 
 * that the correct response is returned (Since this is a mock API it might
 * not return Response code 200, so check the documentation) */

public class _01_Post_Request_And_Assertion_To_Determine_If_Operation_Successful 
{
	@Test
	public void postUserIdWithNonEmptyTitleAndBody_AssertOperationSuccessful() throws Exception
	{
		// Base URL of the RESTful web service
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("title", "an english title");
		requestParams.put("body", "this is a random string");
		requestParams.put("userid", "2");

		request.body(requestParams.toJSONString());
		Response response = request.post("/posts");

		// Get the status line from the Response and perform an assertion
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 201 Created", "OPERATION_SUCCESS");
		
		int statusCode = response.getStatusCode();	
		Assert.assertEquals(statusCode, 201);
	}

}

