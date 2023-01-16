package com.demoProj.services;

import com.demoProj.bean.EmpBean;
import com.demoProj.entity.EmpEntity;
import com.demoProj.repository.EmpRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmpService {
    Logger logger = LoggerFactory.getLogger(EmpService.class);
    @Autowired
    private EmpRepo employeeRepository;

    public List<EmpEntity> getEmpData(){
        logger.debug("getting Employee Data");
        logger.info("getting Employee Data");
        return employeeRepository.findAll();
    }

    public void saveEmployee(EmpBean employee) throws ValidationException {
        if (Objects.nonNull(employee.getEmpId())) {
            logger.debug("updating Employee Data with post method");
            logger.info("updating Employee Data with post method");
            Optional<EmpEntity> empData = employeeRepository.findById(employee.getEmpId());
            if (empData.isPresent()) {
                EmpEntity getData = empData.get();
                getData.setEmpId(employee.getEmpId());
                getData.setComp_id(employee.getCompId());
                getData.setName(employee.getName());
                EmpEntity updateData = employeeRepository.save(getData);
            }
            else {
                throw new ValidationException("Employee id is auto incremented");
            }
        }
            else {
                logger.debug("adding new Employee Data with post method");
                logger.info("adding new Employee Data with post method");
                EmpEntity empL = new EmpEntity();
                empL.setName(employee.getName());
                empL.setComp_id(employee.getCompId());
                EmpEntity savedEmployee = employeeRepository.save(empL);
            }
    }

    public void deleteEmp(int emp_id) throws ValidationException {
        logger.debug("deleted particular employee data using id");
        logger.info("deleted particular employee data using id");
            EmpEntity emp = employeeRepository.getReferenceById(emp_id);
            Optional<EmpEntity> empId = employeeRepository.findById(emp_id);
            if(empId.isPresent()){
                employeeRepository.delete(emp) ;
            }
            else {
                throw new ValidationException("Operation delete was terminate because given employee id is not present");
            }
    }
    public void updateEmp(Integer emp_id, EmpBean employeeRequest) throws ValidationException {
        logger.debug("updating Employee Data with put method");
        logger.info("updating Employee Data with put method");
        Optional<EmpEntity> empData = employeeRepository.findById(emp_id);
        if (empData.isPresent()) {

            EmpEntity getData = empData.get();
            getData.setComp_id(employeeRequest.getCompId());
            getData.setName(employeeRequest.getName());
            EmpEntity updateData = employeeRepository.save(getData);
        }
        else {
            throw new ValidationException("Employee id not present");
        }
    }

    public List<EmpEntity> getByName(String name){
        logger.debug("getting Employee name");
        logger.info("getting Employee name");
        return employeeRepository.findByName(name);
    }
}
