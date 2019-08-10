package validatePost;

import javax.swing.text.AbstractDocument.Content;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;

@SuppressWarnings("unused")
public class simplePost {
	
	@Test
	public void simpelPost01() {
		Response resp = given().
				body("{\"id\":7, \"title\": \"cold day\", \"author\": \"Mali\"}").
				when().
				contentType(ContentType.JSON).
		
				post("http://localhost:3000/posts");
		
		System.out.println(resp.getStatusCode());
	}

}
