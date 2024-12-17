package no.fair.dih.ingestion;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
public class PingIT {

  @Test
  public void testIt() {
    given()
        .when().get("/ping")
        .then()
        .statusCode(200)
        .body(is("\"pong\""));
  }
}
