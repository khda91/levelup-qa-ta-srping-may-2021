package ru.levelup.at.api.rqrsspec;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RestAssuredRqRsExample {

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setBaseUri("https://reqres.in")
            .setContentType(ContentType.JSON)
            .build();

        responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
    }

    @Test
    public void simpleCreateRestAssureTest() {
        given()
            .spec(requestSpecification)
            .body("{\n"
                + "    \"name\": \"morpheus\",\n"
                + "    \"job\": \"leader\"\n"
                + "}")
            .when()
            .post("/api/users")
            .then()
            .spec(responseSpecification)
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
            .spec(requestSpecification)
            .pathParam("userId", 3)
            .when()
            .get("/api/users/{userId}")
            .then()
            .spec(responseSpecification)
            .statusCode(200);
    }
}
