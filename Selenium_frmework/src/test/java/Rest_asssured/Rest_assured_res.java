package Rest_asssured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Rest_assured_res {
	
	public Response get_cmd(String baseURI)
	{
		RestAssured.baseURI=baseURI;
		
		Response response=(Response)
		given()
		
		.when()
			.get()
		.then()
			.extract()
		  ;
		
		return response;
		
	}
	
	public Response post_cmd(String baseURI,JSONObject payload)
	{
		RestAssured.baseURI=baseURI;
		
		Response response=(Response)
				given()
				.contentType("application/json")
				.body(payload)
				
				.when()
					.post()
				.then()
					.extract()
				  ;
		
		return response;
	}
	
	public Response put_cmd(String baseURI,JSONObject payload)
	{
		RestAssured.baseURI=baseURI;
		
		Response response=(Response)
				given()
				.contentType("application/json")
				.body(payload)
				.when()
					.put()
				.then()
					.extract()
				  ;
		
		return response;
	}
	
	public Response delete_cmd(String baseURI)
	{
		RestAssured.baseURI=baseURI;
		
		Response response=(Response)
				given()
				
				.when()
					.delete()
				.then()
					.extract()
				  ;
		
		return response;
	}
}
