package com.demoProj.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTest {


//    @InjectMocks
//    private CalculatorService calculatorService;
//
    @InjectMocks
    private CalculatorService calculatorService;

//
//    CalculatorService calculatorService02 = Mockito.mock(CalculatorService.class);

//    @Before
//    public void setUp() {
//        calculatorService = new CalculatorService();
//        calculatorService. = mock(ScheduleConfig.class);
//    }

    @Test
    public void add01() throws NullPointerException{
        when(calculatorService.add(10, 20)).
                thenReturn(30);
        int sum = calculatorService.add(10, 20);
        Assert.assertEquals(30, sum);
    }
}