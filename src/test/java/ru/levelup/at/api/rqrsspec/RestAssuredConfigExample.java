package ru.levelup.at.api.rqrsspec;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RestAssuredConfigExample {

    @BeforeSuite
    public void setUp() {
        // RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
    }

    @Test
    public void simpleCreateRestAssureTest() {
        given()
            .body("{\n"
                + "    \"name\": \"morpheus\",\n"
                + "    \"job\": \"leader\"\n"
                + "}")
            .when()
            .post("/api/users")
            .then()
            .statusCode(201)
            .assertThat()
            .body("name", equalTo("morpheus"))
            .body("job", equalTo("leader"))
            .body("id", not(empty()))
            .body("createdAt", not(empty()));
    }

    @Test
    public void getUserTest() {
        given()
            .pathParam("userId", 3)
            .when()
            .get("/api/users/{userId}")
            .then()
            .statusCode(200);
    }

    @Test
    public void getAllUserTest() {
        given()
            .header("Localization", "En-Gb")
            .queryParam("page", 2)
            .when()
            .get("/api/users")
            .then()
            .statusCode(200);
    }
}
