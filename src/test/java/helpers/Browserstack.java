package helpers;

import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    public static String videoUrl(String sessionId) {

        return given()
                .auth().basic(config.user(), config.key())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId + ".json")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}
