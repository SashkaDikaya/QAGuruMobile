package helpers;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static String videoUrl(String sessionId) {
       return given()
                .auth().basic("aleksandradikaya_1vRp9C", "3g7Bsvx4xV2W8yHFAg8M")
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .extract()
                .response()
               .path("automation_session.video_url");
    }
}
