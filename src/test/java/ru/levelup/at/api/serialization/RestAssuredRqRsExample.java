package ru.levelup.at.api.serialization;

import static io.restassured.RestAssured.given;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelup.at.api.create.UserRequest;
import ru.levelup.at.api.create.UserResponse;
import ru.levelup.at.api.get.UserGetResponse;

public class RestAssuredRqRsExample {

    private static final Faker FAKER = new Faker();

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
        var name = FAKER.name().fullName();
        var job = FAKER.job().title();
        var request = UserRequest.builder()
                                 .name(name)
                                 .job(job)
                                 .build();

        var actualResponse = given()
            .spec(requestSpecification)
            .body(request)
            .when()
            .post("/api/users")
            .then()
            .spec(responseSpecification)
            .statusCode(HttpStatus.SC_CREATED)
            .extract()
            .as(UserResponse.class);

        var expectedResponse = UserResponse.builder()
                                           .name(name)
                                           .job(job)
                                           .build();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResponse)
                  .usingRecursiveComparison()
                  .ignoringExpectedNullFields()
                  .isEqualTo(expectedResponse);
            softly.assertThat(actualResponse)
                  .extracting(UserResponse::getCreatedAt)
                  .isNotNull();
            softly.assertThat(actualResponse)
                  .extracting(UserResponse::getId)
                  .isNotNull();
        });
    }

    @Test
    public void getUserTest() {
        UserGetResponse actualUser = given()
            .spec(requestSpecification)
            .pathParam("userId", 3)
            .when()
            .get("/api/users/{userId}")
            .then()
            .spec(responseSpecification)
            .statusCode(200)
            .extract()
            .as(UserGetResponse.class);

        System.out.println(actualUser);
    }
}
