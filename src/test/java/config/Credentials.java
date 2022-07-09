package config;

import org.aeonbits.owner.ConfigFactory;

public class Credentials {
    public static BrowserstackConfig browserstack = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());


}
