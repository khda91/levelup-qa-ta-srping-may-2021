package ru.levelup.at.api.serialization;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.api.error.ErrorResponse;
import ru.levelup.at.api.error.UserRequest;

public class RestAssuredErrorExample {

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
    public void emailErrorTest() {
        ErrorResponse actualResponse = given()
            .spec(requestSpecification)
            .body(UserRequest.builder().email("hsdkskd@jdsvjsdva").build())
            .when()
            .post("/api/register")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_BAD_REQUEST)
            .extract()
            .as(ErrorResponse.class);

        ErrorResponse expectedResponse = ErrorResponse.builder()
                                                      .error("Missing password")
                                                      .build();

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }
}
