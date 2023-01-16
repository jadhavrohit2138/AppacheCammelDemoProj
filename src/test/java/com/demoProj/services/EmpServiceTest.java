package com.demoProj.services;

import com.demoProj.entity.EmpEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class EmpServiceTest {

    @InjectMocks
    private EmpService empService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getByName() {
        List<EmpEntity> empEntities = empService.getByName("Rj");
    }
}