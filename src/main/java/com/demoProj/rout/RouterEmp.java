package com.demoProj.rout;

import com.demoProj.predicate.PredicateEmp;
import com.demoProj.processor.ProcessorEmp;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouterEmp extends RouteBuilder {

    @Autowired
    ProcessorEmp processorEmp;

    @Autowired
    PredicateEmp predicateEmp;

    @Override
    public void configure() throws Exception {
        from("activemq:EmployeeQueue")
                .process(processorEmp)
                .choice()
                .when(predicateEmp)
                .to("activemq:ValidationResultQueue") // work in progress
                .otherwise()
                .log("Operation Completed")
                .end();
    }
}
