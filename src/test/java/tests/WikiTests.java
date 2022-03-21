package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("wiki_test")
public class WikiTests extends TestBase{

    @Test
    void checkScreenTest()  {
        step("Check first screen", () ->{
        $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(text("Free Encyclopedia"));
        $(MobileBy.id("org.wikipedia.alpha:id/addLangContainer")).click();
        $(MobileBy.id("org.wikipedia.alpha:id/wiki_language_title")).click();
        $x("//android.widget.LinearLayout[3]").click();
        $x("//android.widget.LinearLayout[3]/android.widget.TextView[1]").click();

        $(MobileBy.AccessibilityId("Navigate up")).click();
        $x("//androidx.recyclerview.widget.RecyclerView").shouldHave(text("Русский"));


        });
    }

}