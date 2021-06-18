import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class second_post_api 
{
@Test
	
	public void getapiresponse ()
	
	{
//		System.setProperty("https.proxyHost", "10.150.203.30");
//		System.setProperty("https.proxyPort", "8080");
		
		// to specify base uri
//		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		String URI ="https://gateway.dev.ilabank.com/api/v1";
		RestAssured.baseURI = URI ;
		
		// Request Object
		RequestSpecification ga = RestAssured.given();
		
		
		//Response Object For PUT Method
		Response response = ga.request(Method.POST ,"accounts/details");
		ga.params("language", "en");
		ga.params("unit", "neo");
		
		
		// Request Payload
		JSONObject requestParam = new JSONObject () ;
		requestParam.put("id", "BH13ABCO1294159101001");
		
		// Request Header
		ga.header ("Content-Type", "application/json");
		ga.header ("x-apikey","3vT7MGyz1gMfybyTyYv08wUg4RzHG6Ih");
		ga.header ("customerId", "1294159");
		
		
		
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
