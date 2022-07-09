package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/browserstack.properties")
public interface BrowserstackConfig extends Config {
    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("app")
    String app();

    @Key("appium_version")
    String appium_version();

    @Key("device")
    String device();

    @Key("os_version")
    String os_version();

    @Key("project")
    String project();

    @Key("build")
    String build();

    @Key("name")
    String name();

    @Key("url")
    String url();
}
