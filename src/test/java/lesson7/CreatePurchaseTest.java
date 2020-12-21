package lesson7;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lesson6.helpers.AppProperties;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreatePurchaseTest {
    File purchase = new File(AppProperties.getProperty("purchase"));

    @Before
    public void point() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";
        CreateAndLoginTest createAndLoginTest = new CreateAndLoginTest();
        createAndLoginTest.login();
    }

    @Test
    public void placeOrder() {
        RestAssured.given()
                .contentType(ContentType.JSON).body(purchase)
                .when().post("/store/order")
                .then().statusCode(200)
                .and().body("id",equalTo(1))
                .and().body("petId",equalTo(2000))
                .and().body("status",equalTo("placed"));
    }

    @Test
    public void findPurchase() {
        RestAssured.given()
                .pathParam("id","1")
                .when().get("/store/order/{id}")
                .then().statusCode(200)
                .and().body("id",equalTo(1))
                .and().body("petId",equalTo(2000))
                .and().body("status",equalTo("placed"));
    }

    @Test
    public void logOut() {
        RestAssured.given()
                .when().get("/user/logout")
                .then().statusCode(200)
                .and().body("message",equalTo("ok"));
    }
}
