package service;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import requestPojo.Address;
import requestPojo.CreatePerson;

public class Service {
	
	public Response createPersonAPI(String name, String surname, String city, String landmark, String state, String zipcode) {
		
		Address address = new Address();
		address.setCity(city);
		address.setLandmark(landmark);
		address.setState(state);
		address.setZipcode(zipcode);
		
		CreatePerson createPerson = new CreatePerson();
		createPerson.setName(name);
		createPerson.setSurname(surname);
		createPerson.setAddress(address);
		
		JSONObject jsonObj = new JSONObject(createPerson);
		System.out.println("JSON payload..");
		System.out.println(jsonObj);
		
		RequestSpecification requestSpecification = given();
		requestSpecification.contentType("application/json");
		requestSpecification.accept("application/json");
		requestSpecification.body(jsonObj);
		
		System.out.println("endpoint URL.. "+ServiceURL.createPersonURL);
		Response response = requestSpecification.post(ServiceURL.createPersonURL);
		
		return response;
		
	}
	
	public static void main(String[] args) {
		Service service = new Service();
		Response data = service.createPersonAPI("name", "surname", "city", "landmark", "state", "560072");
		System.out.println(data.asString());
	}

}
