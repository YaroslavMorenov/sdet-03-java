package lesson7;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class DeleteUserTest {
    @Before
    public void point() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";
    }

    @Test
    public void deleteUser() {
        RestAssured.given()
                .pathParam("username","Morenov")
                .when().delete("/user/{username}")
                .then().statusCode(200);
    }

    @Test
    public void checkDeleteUser() {
        RestAssured.given()
                .pathParam("username","Morenov")
                .when().get("/user/{username}")
                .then().statusCode(404)
                .and().body("message",equalTo("User not found"));
    }
}
