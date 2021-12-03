import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import files.payload;

import static io.restassured.RestAssured.*;

public class Login {

	public static void main(String[] args) {
		
		//VALIDATE ADDPLACE API IS WORKING FINE OR NOT
		
		
		//given = all input detail
		//when = Submit the API , Resorce and http method
		//then = validation
		
		RestAssured.baseURI="http://192.168.1.52:8094";
		String response = given().log().all().header("Content-Type","application/json")
		.body(payload.AddPlace()).when().post("login/")
		.then().assertThat().statusCode(200).header("Server","WSGIServer/0.2 CPython/3.7.5").extract().response().toString();
		System.out.println(response);
//		JsonPath js=new JsonPath(response);
//		String status =js.getString("user_login_status");
//		System.out.println("status");
		
		

	}

}
