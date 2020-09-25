package countriesOfTheWorld;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CapitalCities {
	 Response response;
	 String basePath;
	
	public String returnCapitalCity(String countryNameOrCodeCode) throws Exception{
			
		//Initiates base uri to provided end point service 
		RestAssured.baseURI = "https://restcountries.eu/rest/v2";
			
		//Applies Relaxed Https validation to avoid certificate error
		RestAssured.useRelaxedHTTPSValidation();
		
		//Determines whether country name is provided or country code and iniatates base path
		// In documentation, the "code" is described ISO code that has 2 or 3 letters
		
		if(countryNameOrCodeCode.length()>3)
			this.basePath = "/name/" + countryNameOrCodeCode;
		
		else if (countryNameOrCodeCode.length() <= 3)
			this.basePath = "/alpha/" + countryNameOrCodeCode;
		
		//Stores respond body 
			this.response = 
					given()
					.when()
					 	.get(basePath);
			
		//Parses Json array 
		JsonPath js = response.jsonPath();
		
		//Returns value of capital as string
		String capitalCity = js.getString("capital");
		
		//Prints country name along with capital city
		if(capitalCity != null)
			System.out.println("The Capital city of " + js.getString("name") + " is " + capitalCity + ".");
		return capitalCity;
			
	}
}

