package validateGet;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

	public class SimpleGet {

		
		@Test(enabled = false)
		public void simpleGetTest01() {
			Response resp = when().
					get("http://api.openweathermap.org/data/2.5/weather?q=jackson heights&appid=a4a8f6c5f04d382b1c399da5fe12679f");
			System.out.println(resp.asString());
		}
		
		@Test(enabled=false)
		public void simpleGetTest02() {
			
			Response resp = given().
					param("q","jackson heights").
					param("appid", "a4a8f6c5f04d382b1c399da5fe12679f").
					when().
					get("http://api.openweathermap.org/data/2.5/weather");
			int s = resp.getStatusCode();
			System.out.println("Status Code Returned: "+s);
			Assert.assertEquals(s, 200);
			System.out.println(resp.asString());
			
		}
		
		@Test(enabled = true)
		public void simpleExtract() {
			
			String weather = given().
					param("q","jackson heights").
					param("appid", "a4a8f6c5f04d382b1c399da5fe12679f").
					when().
					get("http://api.openweathermap.org/data/2.5/weather").
					then().
					contentType(ContentType.JSON).
					extract().
					path("weather[0].main");
			Assert.assertEquals(weather, "rain");
			System.out.println(weather);
		}
		
		@Test(enabled = false)
		public void getLocal() {
			
			Response resp = when().
					get("http://localhost:3000/posts");
			System.out.println(resp.asString());
		}

	}
