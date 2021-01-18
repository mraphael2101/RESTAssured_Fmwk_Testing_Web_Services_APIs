package _04_com.masteringrestassured.api.tests.authentication_and_authorization;
import java.util.Base64;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

/* Authorisation is the process of giving access to someone. If you are Authorised then 
   you have access to that resource. Now to Authorise you need to present credentials 
   and that process is known as Authentication */

class User
{
	private String username, password;
	
	public String getUsername(String username) { return username; }
	public String getPassword(String password) { return password; }

	public void setUsername(String username)   { this.username = username; }
	public void setPassword(String password)   { this.password = password; }
}

public class _02_Get_Request__Authorization_Success_200_Response_Code 
{
	@Test
	public void testUserNotExisting()
	{
		User user = new User();
		String authString = user.getUsername("ToolsQA") + ":" + user.getPassword("TestPassword");
		byte[] base64Encoded = Base64.getEncoder().encode(authString.getBytes());
		String encodedString = new String(base64Encoded);
		
		JsonPath response = RestAssured
				.given()
				.header("Authorization", "Basic " + encodedString)
				.when()
				.get("http://restapi.demoqa.com/authentication/CheckForAuthentication")
				.then()
				.statusCode(200)
				.extract().jsonPath();
			
		Assert.assertEquals("OPERATION_SUCCESS"/*Value*/, response.getString("FaultId")/*Node Name*/);
		Assert.assertEquals("Operation completed successfully"/*Value*/, response.getString("Fault")/*Node Name*/);
	}
}
