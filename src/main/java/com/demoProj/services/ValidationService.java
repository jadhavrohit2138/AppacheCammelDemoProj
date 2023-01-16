package com.demoProj.services;


import com.demoProj.bean.ValidationBean;
import com.demoProj.entity.ValidationEntity;
import com.demoProj.repository.ValidationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidationService {
    Logger logger = LoggerFactory.getLogger(EmpService.class);


    @Autowired
    private ValidationRepo validationRepo;

    public void saveValidations(ValidationBean validationBean){
        ValidationEntity validationEntity = new ValidationEntity();
        validationEntity.setCode(validationBean.getCode());
        validationEntity.setReason(validationBean.getReason());
        validationEntity.setType(validationBean.getType());
        ValidationEntity savedEmployee = validationRepo.save(validationEntity);
        }

    public List<ValidationEntity> getValidations(){
        logger.debug("Debugging Validation Data");
        logger.info("Getting Validation Data");
        return validationRepo.findAll();
    }

}
