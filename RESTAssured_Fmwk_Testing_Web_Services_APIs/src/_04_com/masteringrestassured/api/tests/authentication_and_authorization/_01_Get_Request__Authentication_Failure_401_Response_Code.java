package _04_com.masteringrestassured.api.tests.authentication_and_authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/* The majority of the time you will be hitting REST API’s which are secured. By secure 
   we mean that the API’s which require you to provide identification. Identification 
   can be provided in the form of Username and a Password, Authentication tokens, Secret keys
   and Bio-metrics, amongst others

   A REST request can have a special header called Authorization Header, this header can 
   contain the credentials (username and password) in some form. Once a request with 
   Authorization Header is received, server can validate the credentials and can let you 
   access the private resources */


public class _01_Get_Request__Authentication_Failure_401_Response_Code 
{
	@Test
	public void AuthenticationBasics()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
		RequestSpecification request = RestAssured.given();
	 
		Response response = request.get();
		System.out.println("Status code: " + response.getStatusCode());
		System.out.println("Status message " + response.body().asString());
	}
}
