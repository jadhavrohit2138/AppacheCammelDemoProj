package com.demoProj.processor;

import com.demoProj.bean.EmpBean;
import com.demoProj.bean.ValidationBean;
import com.demoProj.entity.EmpEntity;
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
import java.util.List;

@Component
public class ProcessorEmp implements Processor {

    @Autowired
    EmpService empService;
    @Autowired
    ValidationService validationService;
    ValidationBean validationBean;

    Logger logger = LoggerFactory.getLogger(EmpService.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        String strValue = (String) exchange.getIn().getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            if (strValue.startsWith("{") || strValue.startsWith("[")){
                EmpBean empBean = objectMapper.readValue(strValue,EmpBean.class); // jason to java object or Deserialization
                if (empBean.getOperation().equalsIgnoreCase("create")){
                    empService.saveEmployee(empBean);
                }
                else if(empBean.getOperation().equalsIgnoreCase("update")){
                    empService.updateEmp(empBean.getEmpId(),empBean);
                }
                else if(empBean.getOperation().equalsIgnoreCase("read")){
                    List<EmpEntity> obj = empService.getEmpData();
                }
                else if(empBean.getOperation().equalsIgnoreCase("delete")){
                    empService.deleteEmp(empBean.getEmpId());
                }
                else {
                    throw new ValidationException("Operation is not match");
                }
        }
            else {
                throw new ValidationException("Data should be in JSON format");
            }
    }
        catch (ValidationException validationException){
            logger.error("Validation occurred");
            validationBean = new ValidationBean(400,validationException.getMessage().toString(),"EMP");
            String validationMapper = objectMapper.writeValueAsString(validationBean); // convert java obj to str
            validationService.saveValidations(validationBean);
            exchange.getIn().setBody(validationMapper);
        }
        catch (Exception e){
            logger.error("Exception occurred");
            validationBean = new ValidationBean(500,e.getMessage().toString(),"EMP");
            String validationMapper = objectMapper.writeValueAsString(validationBean);
            validationService.saveValidations(validationBean);
            exchange.getIn().setBody(validationMapper);
        }
    }
}
