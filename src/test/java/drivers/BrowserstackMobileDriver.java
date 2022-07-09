package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.Credentials;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.appium_version", Credentials.browserstack.appium_version());
        mutableCapabilities.setCapability("browserstack.user", Credentials.browserstack.user());
        mutableCapabilities.setCapability("browserstack.key", Credentials.browserstack.key());
        mutableCapabilities.setCapability("app", Credentials.browserstack.app());
        mutableCapabilities.setCapability("device", Credentials.browserstack.device());
        mutableCapabilities.setCapability("os_version", Credentials.browserstack.os_version());
        mutableCapabilities.setCapability("project", Credentials.browserstack.project());
        mutableCapabilities.setCapability("build", Credentials.browserstack.build());
        mutableCapabilities.setCapability("name", Credentials.browserstack.name());

        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(Credentials.browserstack.url());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}