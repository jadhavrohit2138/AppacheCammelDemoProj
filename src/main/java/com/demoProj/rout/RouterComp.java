package com.demoProj.rout;

import com.demoProj.predicate.PredicateComp;
import com.demoProj.predicate.PredicateEmp;
import com.demoProj.processor.ProcessorComp;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouterComp extends RouteBuilder {

    @Autowired
    ProcessorComp processorComp;

    @Autowired
    PredicateComp predicateComp;

    @Override
    public void configure() throws Exception {
        from("activemq:CompanyQueue")
                .process(processorComp)
                .choice()
                .when(predicateComp)
//                .log("")
//                .otherwise()
//                .log("")
                .end();

    }
}
