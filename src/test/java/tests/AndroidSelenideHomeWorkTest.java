package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("selenide")
public class AndroidSelenideHomeWorkTest extends TestBase{

    @Test
    void searchTest()  {
        step("Type search", () ->{
        $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_container")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).setValue("BrowserStack");
        });

        step("Verify content found", () ->{
        $$(byClassName("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }

}
