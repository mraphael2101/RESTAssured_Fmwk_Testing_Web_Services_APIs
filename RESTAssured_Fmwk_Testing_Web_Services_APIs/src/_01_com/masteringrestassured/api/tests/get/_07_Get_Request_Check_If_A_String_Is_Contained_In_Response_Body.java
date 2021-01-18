package _01_com.masteringrestassured.api.tests.get;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;




public class _07_Get_Request_Check_If_A_String_Is_Contained_In_Response_Body 
{	
	@Test
	public void getTest()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/London");
	 
		// Retrieve the body of the Response
		ResponseBody body = response.getBody();
	 
		// To check for sub string presence get the Response body as a String
		String bodyAsString = body.asString();

		// convert the body into lower case and then do a comparison to ignore casing.
		Assert.assertEquals(bodyAsString.toLowerCase().contains("London") /*Expected value*/, 
				true /*Actual Value*/, "Response body contains London");
	}
	
}