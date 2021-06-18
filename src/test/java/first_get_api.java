import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class first_get_api 
{
	
	@Test
	
	public void getapiresponse ()
	
	{
		// to specify base uri
//		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RestAssured.baseURI = "https://reqres.in/api" ;
		
		// Request Object
		RequestSpecification ga = RestAssured.given();
		
		//Response Object
		Response response = ga.request(Method.GET ,"/users?page=2");
		
		// Print response
		String responsepoutput = response.getBody().asString();
		System.out.println("Ouput Response is : " +responsepoutput);
		
		// Status code validation
		
		int status_code = response.getStatusCode();
		System.out.println("Status Code is : "+status_code );
		Assert.assertEquals(status_code, 200);
		
		// Status line verification
		
		String status_line = response.getStatusLine ();
		System.out.println("Status Line is : " +status_line);
		Assert.assertEquals(status_line, "HTTP/1.1 200 OK");
		
		
		
	}
	

}
