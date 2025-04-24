package com.demoProj.exception;

public class S3Exception extends Exception {

    public S3Exception(Exception e, String message) {
        super(message, e);
    }

}