package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("wiki_test")
public class WikiTests extends TestBase {

    @Test
    void checkScreenTest() {
        step("Check first screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Free Encyclopedia"));
        });

        step("Set russian language", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/addLangContainer")).click();
            $(MobileBy.xpath("//*[@text='ADD LANGUAGE']")).click();
            $(MobileBy.xpath(("//*[@text='Русский']"))).click();
            $(MobileBy.xpath(("//*[@content-desc='Navigate up']"))).click();
        });

        step("Check russian language", () -> {
            $(MobileBy.xpath(("//*[contains(@text,'Русский')]"))).shouldHave(text("Русский"));
        });

        step("Go to second screen", () -> {
            $(MobileBy.xpath(("//*[@text='CONTINUE']"))).click();
        });

        step("Check second screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Customize the feed to your interests"));
        });

        step("Go to third screen", () -> {
            $(MobileBy.xpath(("//*[@text='CONTINUE']"))).click();
        });

        step("Check third screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Login to your Wikipedia account"));
        });

        step("Go to fourth screen", () -> {
            $(MobileBy.xpath(("//*[@text='CONTINUE']"))).click();
        });

        step("Check fourth screen", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView")).shouldHave(text("Learn more"));

        });
    }

}