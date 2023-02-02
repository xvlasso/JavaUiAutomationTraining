package apiTests;

import api.NewHopeFilmResponse;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.is;

public class ApiTest {

    private static final String BASE_URL = "https://swapi.dev";
    private static final String NEW_HOPE_ENDPOINT = "/api/films/1/";

    @BeforeClass
    public void beforeClass() {
        RestAssured.useRelaxedHTTPSValidation();
    }

    @Test
    public void test() {
        NewHopeFilmResponse response = RestAssured.given()
                .baseUri(BASE_URL)
                .when()
                .get(NEW_HOPE_ENDPOINT)
                .then()
                .statusCode(200)
                .body("title", is("A New Hope"))
                .extract()
                .jsonPath()
                .getObject(".", NewHopeFilmResponse.class);
        System.out.println(response);
        Assert.assertNotNull(response.getPlanets());
    }
}
