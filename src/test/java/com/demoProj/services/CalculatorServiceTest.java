package com.demoProj.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {


//    @InjectMocks
//    private CalculatorService calculatorService;
//
//    @Mock
//    private CalculatorService calculatorService01;


    CalculatorService calculatorService02 = Mockito.mock(CalculatorService.class);

    @Test
    public void add() throws NullPointerException{

        int sum = calculatorService02.add(10, 20);
        Assert.assertEquals(30, sum);
    }
}