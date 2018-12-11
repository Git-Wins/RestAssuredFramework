package testCases;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import service.ServiceURL;

public class TestOne {

	public static void main(String[] args) {
		
/*		//RequestSpecification requestSpecification;
		//Response response;
		int ipsCount = 2;
		String input0 = "id";
		String input1 = "appid";
		
		//requestSpecification = given();
		for(int i=0;i<=ipsCount;i++) {
			//requestSpecification.param("input"+i, idInput);
			System.out.println("input"+i);
		}
		
		
		//System.out.println("endpoint URL.. "+ServiceURL.openWeatherURL);
		//response = requestSpecification.get(ServiceURL.openWeatherURL);
		 
		  /*BiMap<String, String> biMap = HashBiMap.create();
		biMap.put(input0, "2172797");
		biMap.put(input1, "b6907d289e10d714a6e88b30761fae22");
		
		//System.out.println(biMap.get("id"));
		//System.out.println(biMap.inverse().get("2172797"));
		
		*/
		 

		RequestSpecification requestSpecification = given();
		Response response;
		int ipsCount = 2;
		String param1 = "id";
		String param1Val = "2172797"; 
		String param2 = "appid";
		String param2Val = "b6907d289e10d714a6e88b30761fae22"; 
		
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
		
		System.out.println(response.asString());
		
	}

}
