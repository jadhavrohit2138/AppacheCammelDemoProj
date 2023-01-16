package com.demoProj.services;

import com.demoProj.bean.CompBean;
import com.demoProj.entity.CompEntity;
import com.demoProj.repository.CompRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompService {

    @Autowired
    CompRepo compRepo;

    Logger logger = LoggerFactory.getLogger(CompService.class);


    public List<CompEntity> getCompData(){
        return compRepo.findAll();
    }

    public Boolean saveCompany(CompBean company){
        try {
            if (Objects.nonNull(company.getCompID())) {
                logger.debug("updating Company Data with post method");
                logger.info("updating Company Data with post method");
                Optional<CompEntity> empData = compRepo.findById(company.getCompID());
                CompEntity getData = empData.get();
                getData.setCompId(company.getCompID());
                getData.setCompName(company.getCompName());
                CompEntity updateData = compRepo.save(getData);
                return true;
            }
            else {
                logger.debug("adding new Company Data with post method");
                logger.info("adding new Company Data with post method");
                CompEntity empL = new CompEntity();
                empL.setCompName(company.getCompName());
                CompEntity savedEmployee = compRepo.save(empL);
                return true;
            }
        } catch (Exception e) {
            return  false;
        }
    }

    public Boolean deleteComp(int comp_id) throws ValidationException {
        logger.debug("deleted particular Company data using id");
        logger.info("deleted particular Company data using id");
            CompEntity comp = compRepo.getReferenceById(comp_id);
            Optional<CompEntity> compId = compRepo.findById(comp_id);
            if(compId.isPresent()){
                compRepo.delete(comp);
                return true;
            }
            else {
                throw new ValidationException("Operation delete was terminate because given Company id is not present");
            }
        }


    public Boolean updateComp(Integer comp_id, CompBean compBean) {
        logger.debug("updating Company Data with put method");
        logger.info("updating Company Data with put method");
        Optional<CompEntity> compData = compRepo.findById(comp_id);
        if (compData.isPresent()) {
            CompEntity getData = compData.get();
            getData.setCompId(compBean.getCompID());
            getData.setCompName(compBean.getCompName());
            CompEntity updateData = compRepo.save(getData);
            return true;
        }else {
            return false;
        }
    }
}
