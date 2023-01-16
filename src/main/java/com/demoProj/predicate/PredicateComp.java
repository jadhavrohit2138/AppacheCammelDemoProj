package com.demoProj.predicate;

import com.demoProj.bean.ValidationBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.springframework.stereotype.Component;

@Component
public class PredicateComp implements Predicate {
    @Override
    public boolean matches(Exchange exchange) {
        ObjectMapper objectMapper =new ObjectMapper();
        try {
            ValidationBean validationBean = objectMapper.readValue(exchange.getMessage().getBody().toString(),ValidationBean.class);
            System.out.println(validationBean.getCode());
            return validationBean.getCode() == 500 || validationBean.getCode() == 400;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
