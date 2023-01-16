package com.demoProj.processor;

import com.demoProj.bean.CompBean;
import com.demoProj.bean.ValidationBean;
import com.demoProj.services.CompService;
import com.demoProj.services.EmpService;
import com.demoProj.services.ValidationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.xml.bind.ValidationException;

@Component
public class ProcessorComp implements Processor {

    @Autowired
    CompService compService;

    @Autowired
    ValidationService validationService;

    Logger logger = LoggerFactory.getLogger(EmpService.class);

    ValidationBean validationBean;


    @Override
    public void process(Exchange exchange) throws Exception {
        String strValue = (String) exchange.getIn().getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        Boolean flag;
        try {
            if (strValue.startsWith("{") || strValue.startsWith("[")){
                CompBean compBean = objectMapper.readValue(strValue,CompBean.class); // jason to java object or Deserialization
                if (compBean.getOperation().equalsIgnoreCase("create")){
                    flag = compService.saveCompany(compBean);
                    System.out.println(flag);
                }
                else if(compBean.getOperation().equalsIgnoreCase("update")){
                    flag = compService.updateComp(compBean.getCompID(),compBean);
                    System.out.println(flag);
                }
                else if(compBean.getOperation().equalsIgnoreCase("delete")){
                    flag = compService.deleteComp(compBean.getCompID());
                    System.out.println(flag);
                }
                else
                {
                    throw new ValidationException("Operation is not match");
                }
            }
            else {
                throw new ValidationException("Data should be in JSON format");
            }
        }
        catch (ValidationException validationException){
            logger.error("Validation occurred");
            validationBean = new ValidationBean(400,validationException.getMessage().toString(),"COMP");
            String validationMapper = objectMapper.writeValueAsString(validationBean);
            validationService.saveValidations(validationBean);
            exchange.getIn().setBody(validationMapper);
        }
        catch (Exception e){
            logger.error("Exception occurred");
            validationBean = new ValidationBean(500,e.getMessage().toString(),"COMP");
            String validationMapper = objectMapper.writeValueAsString(validationBean);
            validationService.saveValidations(validationBean);
            exchange.getIn().setBody(validationMapper);
        }
    }
}
