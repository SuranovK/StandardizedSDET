package countriesOfTheWorld;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunCapitalCities {
	@DataProvider()
	public Object[][] getTestData(){
		return new Object[][]
				{ 
			{"United States of America"},
			{"France"},
			{"Kyrgyzstan"},
			{"GB"},
			{"ZW"},
			{"TV"},
			{"Meico"},
			{"Sama"},
			{"UK"},
			{"TTT"}
	};	
	}
	
	@Test(dataProvider = "getTestData")
	public void runTest(String countryNameOrCode) throws Exception{
		
		//Creates CapitalCity object  
		CapitalCities cities = new CapitalCities();
		
		//Initiates returned capital city name 
		String capitalCity = cities.returnCapitalCity(countryNameOrCode);
		
		//Makes assertion to check returned value is valid or null
		Assert.assertNotNull(capitalCity, "Value is null. " + countryNameOrCode + " is not valid name or code.");
	
	}

}
