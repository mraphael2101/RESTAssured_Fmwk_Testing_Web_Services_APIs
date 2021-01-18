package _01_com.masteringrestassured.api.tests.get;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class _05_Get_Request_Print_All_Headers_Received_In_A_Response 
{
	@Test
	public void getRequest()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/London");
	 
		/* Get all the headers. Return value is of type Headers.
		   Headers class implements Iterable interface, hence we
		   can apply an advanced for loop to iterate through all 
		   of the Headers as shown in the code below */
		Headers allHeaders = response.headers();
	 
		for(Header header : allHeaders)
		{
			System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
		}
	}
}
