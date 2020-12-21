package lesson7;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lesson6.helpers.AppProperties;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class CreatePetTest {
    File addPet = new File(AppProperties.getProperty("addpet"));

    @Before
    public void point() {
        RestAssured.baseURI = "https://petstore.swagger.io";
        RestAssured.basePath = "/v2";
        CreateAndLoginTest createAndLoginTest = new CreateAndLoginTest();
        createAndLoginTest.login();
    }

    @Test
    public void addNewPet() {
        RestAssured.given()
                .contentType(ContentType.JSON).body(addPet)
                .when().post("pet")
                .then().statusCode(200);
    }

    @Test
    public void findPetById() {
        RestAssured.given()
                .pathParam("id","2000")
                .when().get("/pet/{id}")
                .then().statusCode(200)
                .and().body("id",equalTo(2000))
                .and().body("name",equalTo("Name"));
    }
}
