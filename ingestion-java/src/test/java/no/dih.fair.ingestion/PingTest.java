package no.fair.dih.ingestion;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class PingTest {
  @Test
  void testHelloEndpoint() {
    given()
        .when().get("/ping")
        .then()
        .statusCode(200)
        .body(is("Pong"));
  }

}
