package testCases;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.response.Response;
import responsePojo.OpenWeatherResponse;
import service.ServiceOpenWeather;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class TestOpenWeather extends ServiceOpenWeather{

	Response data;
	
	@BeforeMethod
	public void setValues() {
	
		
		idVal = "2172797";
		appIdVal = "b6907d289e10d714a6e88b30761fae22";
		
	}

	@Test
	public void toTest() {
			
		data = new ServiceOpenWeather()
						.openWeatherAPI(idVal, appIdVal);
		System.out.println(data.asString());
		
		Gson gson = new Gson();
		OpenWeatherResponse openWeatherResponse = gson.fromJson(data.asString(), OpenWeatherResponse.class) ;
		
		int c = (int) openWeatherResponse.getClouds().getAll();
		
		Assert.assertEquals(openWeatherResponse.getName(), "Cairns");
		Assert.assertEquals(c, 40);
		Assert.assertEquals(openWeatherResponse.getWeather().get(0).getId().intValue(), 802);
	
	}

}
