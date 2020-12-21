package lesson7;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lesson6.helpers.AppProperties;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreateAndLoginTest {
    File createUser = new File(AppProperties.getProperty("createuserpath"));

    @Before
    public void point() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";
    }

    @Test
    public void create() {
        RestAssured.given()
                .contentType(ContentType.JSON).body(createUser)
                .when().post("/user")
                .then().statusCode(200)
                .and().body("type",equalTo("unknown"));
    }

    @Test
    public void login() {
        RestAssured.given()
                .pathParam("username","Morenov").pathParam("password","qwerty").log().all()
                .when().get("/user/login?{username}&{password}")
                .then().statusCode(200)
                .and().body("message",Matchers.startsWith("logged in user session:"));
    }

    @Test
    public void logOut() {
        RestAssured.given()
                .when().get("/user/logout")
                .then().statusCode(200)
                .and().body("message",equalTo("ok"));
    }
}
