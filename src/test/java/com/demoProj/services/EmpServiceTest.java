package com.demoProj.services;


import com.demoProj.repository.EmpRepo;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class EmpServiceTest {

    @Mock
    private EmpRepo employeeRepository;

    @InjectMocks
    private EmpService empService;

}
