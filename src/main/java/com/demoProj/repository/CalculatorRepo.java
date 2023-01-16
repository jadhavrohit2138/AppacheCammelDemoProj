package com.demoProj.repository;


import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepo {

    public String joinStr(String str){
        return "hello"+str;
    }
}
