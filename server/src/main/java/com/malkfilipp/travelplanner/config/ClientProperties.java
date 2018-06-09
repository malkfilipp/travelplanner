package com.malkfilipp.travelplanner.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("travelplanner.client")
public class ClientProperties {
    private String origin;
    private Integer maxAge;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }
}
