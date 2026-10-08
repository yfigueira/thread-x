package pl.threadx.bootstrap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BootstrapApplicationIT {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void configureRestAssured() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = this.port;
        RestAssured.basePath = "api";
    }

    @Test
    void shouldCalculateParams() {
        given().contentType(ContentType.JSON)
                .body("""
                      {
                        "threadSize": "_1",
                        "threadPerInch": "_8",
                        "toleranceClass": "_2A"
                      }
                      """)
                .when()
                .post("v1/inch-threads/params-calc")
                .then()
                .statusCode(200)
                .header("Content-Type", ContentType.JSON.toString())
                .body("pitch", notNullValue())
                .body("fundamentalTriangle", notNullValue());
    }

    @ParameterizedTest
    @MethodSource("notSupportedValueArguments")
    void whenAtLeastOneNotSupportedValueIsProvided_ShouldReturn400BadRequest(String body) {
        given().contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("v1/inch-threads/params-calc")
                .then()
                .statusCode(400)
                .header("Content-Type", ContentType.JSON.toString())
                .body("message", is(equalTo("At least one of the provided values is not supported")));
    }

    @Test
    void whenUnsupportedSizeAndThreadsPerInchCombinationReceived_ShouldReturn422UnprocessableContent() {
        given().contentType(ContentType.JSON)
                .body("""
                      {
                        "threadSize": "Nr0",
                        "threadPerInch": "_10",
                        "toleranceClass": "_2A"
                      }
                      """)
                .when()
                .post("v1/inch-threads/params-calc")
                .then()
                .statusCode(422)
                .header("Content-Type", ContentType.JSON.toString())
                .body("message", is(equalTo("The combination of thread size Nr 0 with 10 threads per inch is not supported")));
    }

    private static Stream<Arguments> notSupportedValueArguments() {
        return Stream.of(
            Arguments.of("""
                      {
                        "threadSize": "UNSUPPORTED",
                        "threadPerInch": "_8",
                        "toleranceClass": "_2A"
                      }
                      """),
            Arguments.of("""
                      {
                        "threadSize": "_1",
                        "threadPerInch": "UNSUPPORTED",
                        "toleranceClass": "_2A"
                      }
                      """),
            Arguments.of("""
                      {
                        "threadSize": "_1",
                        "threadPerInch": "_8",
                        "toleranceClass": "UNSUPPORTED"
                      }
                      """)
        );
    }
}
