package com.demoProj.services;


import com.demoProj.repository.CalculatorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    @Autowired
    CalculatorRepo calculatorRepo;


    public int add(int num1,int num2){
        System.out.println(num1);
        System.out.println(num2);

        return num1 + num2;
    }

    public String callMethod(String str){

        return calculatorRepo.joinStr(str);
    }
}
