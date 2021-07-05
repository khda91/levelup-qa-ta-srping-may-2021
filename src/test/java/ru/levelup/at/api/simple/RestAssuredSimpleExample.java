package ru.levelup.at.api.simple;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class RestAssuredSimpleExample {

    @Test
    public void simpleCreateRestAssureTest() {
        given()
            .log().all()
            .contentType(ContentType.JSON)
            .body("{\n"
                + "    \"name\": \"morpheus\",\n"
                + "    \"job\": \"leader\"\n"
                + "}")
            .when()
            .post("https://reqres.in/api/users")
            .then()
            .log().all()
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
            .contentType(ContentType.JSON)
            .when()
            .get("https://reqres.in/api/users/2")
            .then()
            .statusCode(200);
    }
}
