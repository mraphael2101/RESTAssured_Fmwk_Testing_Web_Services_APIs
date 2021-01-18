package _03_com.masteringrestassured.api.tests.serialization_and_deserialization;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

/* Serialization and Deserialization are programming techniques where we convert 
Objects to Byte Streams and from Byte Streams back to Objects. The object converts 
the Response body into a Java Class representing a JSON, or any other structured data 
including XML, into a programming class which is known as Deserialization of JSON. 
The term Deserialization means the conversion from a String form of JSON into a Class form 
This is also known as Object Representation of structured data, which in this case is JSON */

/* The purpose of this class is to store all the nodes present in the Success Response
Variable where value of SuccessCode node, and Message node will be copied. The name 
should exactly match the node name that is present in the Json */

@Test
class RegistrationSuccessResponse { public String SuccessCode;		public String Message; }	

@Test
class RegistrationFailureResponse {	 String FaultId;	String fault; }

public class _05_Post_Request_Deserializes_A_Json_Response 
{
	@Test
	public void RegistrationSuccessful() 
	{
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();
	 
		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender");         
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "63userf2d3d2011");   
		requestParams.put("Password", "password1");	
		requestParams.put("Email",  "ed26dff39@gmail.com");
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");
		
		ResponseBody body = response.getBody();
		System.out.println(response.body().asString());
	 
		if(response.statusCode() == 200) 
		{
			// Deserialize the Response body into RegistrationFailureResponse
			RegistrationFailureResponse responseBody = body.as(RegistrationFailureResponse.class);
	 
			// Use the RegistrationFailureResponse class instance to Assert the values of Response
			Assert.assertEquals("User already exists", responseBody.FaultId);
			Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.fault);				
		}
		
		else if (response.statusCode() == 201) 
		{	
			RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
			
			Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
			Assert.assertEquals("Operation completed successfully", responseBody.Message);		
		}}}

// If possible we should rely on Inheritance to cater to varied Responses being returned by an API endpoint, instead