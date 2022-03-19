package helpers;

import config.Credentials;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static String videoUrl(String sessionId) {

        String login = Credentials.config.user();
        String password = Credentials.config.key();

        return given()
                .auth().basic(login, password)
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}
