package lesson7;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class CreateAndLoginTest {
    @Before
    public void point() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";
    }

    @Test
    public void create() {
        RestAssured.given()
                .contentType("application/json").body("{\n" +
                "    \"id\": 1994,\n" +
                "    \"username\": \"Morenov\",\n" +
                "    \"firstName\": \"Yaroslav\",\n" +
                "    \"lastName\": \"Pavlovich\",\n" +
                "    \"email\": \"yaroslav@mail.ru\",\n" +
                "    \"password\": \"qwerty\",\n" +
                "    \"phone\": \"+7 (922) 222-22-22\",\n" +
                "    \"userStatus\": 12\n" +
                "}"
        )
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
