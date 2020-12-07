package lesson7;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class CreatePetTest {
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
                .contentType("application/json").body("{\n" +
                "    \"name\": \"Name\",\n" +
                "    \"photoUrls\": [\n" +
                "        \"photos\"\n" +
                "    ],\n" +
                "    \"id\": \"2000\",\n" +
                "    \"category\": {\n" +
                "        \"id\": \"1\",\n" +
                "        \"name\": \"cat\"\n" +
                "    },\n" +
                "    \"tags\": [\n" +
                "        {\n" +
                "            \"id\": \"1\",\n" +
                "            \"name\": \"color\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"2\",\n" +
                "            \"name\": \"years\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"status\": \"good\"\n" +
                "}")
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
