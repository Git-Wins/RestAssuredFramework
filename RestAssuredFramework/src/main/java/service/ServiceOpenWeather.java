package service;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;

import com.google.gson.Gson;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestPojo.Address;
import requestPojo.CreatePerson;
import responsePojo.OpenWeatherResponse;

public class ServiceOpenWeather {
	
	public String idVal, appIdVal;
	
	RequestSpecification requestSpecification;
	Response response;
	/*	int ipsCount = 2;
	String input0 = "id";
	String input1 = "appid";*/
	
	/*List<String> list = new ArrayList<String>();
	list*/
	
	public Response openWeatherAPI(String idInput, String appIdInput) {
		
		requestSpecification = given();
		requestSpecification.param("id", idVal);
		requestSpecification.param("appid", appIdVal);
		
		System.out.println("endpoint URL.. "+ServiceURL.openWeatherURL);
		response = requestSpecification.get(ServiceURL.openWeatherURL);
		
		return response;
		
	}
	
	/*public Response openWeatherGeneric(String idInput, String appIdInput) {
		
		RequestSpecification requestSpecification = given();
		Response response;
		int ipsCount = 2;
		//String param1 = "id";
		String param1Val = idInput; 
		//String param2 = "appid";
		String param2Val = appIdInput; 
		
		List<String> list1 = new ArrayList<String>();
		list1.add(param1);
		list1.add(param2);
		
		List<String> list2 = new ArrayList<String>();
		list2.add(param1Val);
		list2.add(param2Val);
		
		for(int i=0;i<ipsCount;i++) {
			requestSpecification.param(list1.get(i), list2.get(i));
		}
		
		response = requestSpecification.get(ServiceURL.openWeatherURL);
		
		return response;
	}*/
	
	/*public static void main(String[] args) {
		ServiceOpenWeather service = new ServiceOpenWeather();
		Response data = service.openWeatherAPI("2172797", "b6907d289e10d714a6e88b30761fae22");
		System.out.println(data.asString());
		
		Gson gson = new Gson();
		OpenWeatherResponse openWeatherResponse = gson.fromJson(data.asString(), OpenWeatherResponse.class) ;
		
		//System.out.println(openWeatherResponse.getName());
		int c = (int) openWeatherResponse.getClouds().getAll();
		
		Assert.assertEquals(openWeatherResponse.getName(), "Cairns");
		Assert.assertEquals(c, 40);//.assertEquals(openWeatherResponse.getClouds().getAll(), 40);
		
	}*/

}
