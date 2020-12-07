package lesson7;

import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class CreatePurchaseTest {

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
                .contentType("application/json").body("{\n" +
                "  \"id\": 1,\n" +
                "  \"petId\": 2000,\n" +
                "  \"quantity\": 1,\n" +
                "  \"shipDate\": \"2020-11-15T07:00:36.093Z\",\n" +
                "  \"status\": \"placed\",\n" +
                "  \"complete\": true\n" +
                "}")
                .when().post("/store/order")
                .then().statusCode(200)
                .and().body("id",equalTo(1))
                .and().body("petId",equalTo(2000))
                .and().body("status",equalTo("placed"));
    }

    @Test
    public void findPurchase(){
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
