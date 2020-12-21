package lesson7;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lesson6.helpers.AppProperties;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class UpdateUserTest {
    File updateUser = new File(AppProperties.getProperty("updateuser"));

    @Before
    public void point() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";
    }

    @Test
    public void updateUser() {
        RestAssured.given().log().all()
                .contentType(ContentType.JSON).body(updateUser)
                .pathParam("username","Morenov")
                .when().put("/user/{username}")
                .then().statusCode(200)
                .and().body("type",equalTo("unknown"));
    }

    @Test
    public void checkUpdate() {
        RestAssured.given().log().all()
                .pathParam("username","Morenov").log().all()
                .when().get("/user/{username}")
                .then().statusCode(200)
                .and().body("phone",equalTo("+7 (922) 222-22-21"));
    }
}
