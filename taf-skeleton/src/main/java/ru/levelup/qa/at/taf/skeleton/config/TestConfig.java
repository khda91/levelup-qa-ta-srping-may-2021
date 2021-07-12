package ru.levelup.qa.at.taf.skeleton.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.ConfigCache;

import java.net.URL;

@Sources({
        "classpath:${env}.properties",
        "system:properties",
        "system:env"
})
public interface TestConfig extends Config {

    @Key("site.url")
    String siteUrl();

    @Key("web.driver.timeout")
    Long webDriverTimeout();

    @Key("remote.driver.url")
    URL remoteDriverUrl();

    static TestConfig getInstance() {
        return ConfigCache.getOrCreate(TestConfig.class);
    }
}
