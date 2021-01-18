package _01_com.masteringrestassured.api.tests.get;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class _03_Get_Request_Print_Out_Response_Body 
{ 
	
	@Test
	public void GetWeatherDetails()
	{   
		// Specify the base URL to the RESTful web service i.e. the root address of the resource
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
 
		/* Get the RequestSpecification of the request that you want to sent
		   to the server. The server is specified by the BaseURI provided in 
		   the previous step */
		RequestSpecification httpRequest = RestAssured.given();
 
		/* Make a request to the server by specifying the method Type and the method URL.
		   This will return the Response which is stored in a response variable */
		Response response = httpRequest.request(Method.GET, "/Hyderabad");
 
		/* Print the body of the message to see what response
		   was recieved from the server */
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}

}