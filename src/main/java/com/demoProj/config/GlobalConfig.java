package com.demoProj.config;

import com.fasterxml.jackson.annotation.JsonProperty;


public class GlobalConfig {

    @JsonProperty("demo.google.url")
    private String demoProjectUrl;

    public GlobalConfig() {
    }

    public String getDemoProjectUrl() {
        return demoProjectUrl;
    }
}