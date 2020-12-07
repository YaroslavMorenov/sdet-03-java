package lesson7;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class DeletePurchaseAndPetTest {
    @Before
    public void point() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";
    }

    @Test
    public void deletePurchase() {
        RestAssured.given()
                .pathParam("id","1")
                .when().delete("/store/order/{id}")
                .then().statusCode(200)
                .and().body("message",equalTo("1"));
    }

    @Test
    public void deletePet() {
        RestAssured.given()
                .pathParam("petId","2000")
                .when().delete("/pet/{petId}")
                .then().statusCode(200)
                .and().body("message",equalTo("2000"));
    }
}
