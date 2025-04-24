package com.demoProj.exception;

public class ConfigResolverException extends Exception {

    public ConfigResolverException(Exception e, String message) {
        super(message, e);
    }

}