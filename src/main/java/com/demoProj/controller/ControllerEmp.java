package com.demoProj.controller;

import com.demoProj.bean.EmpBean;
import com.demoProj.entity.EmpEntity;
import com.demoProj.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employee")
public class ControllerEmp {
        @Autowired
        private EmpService empService;

    @GetMapping("/name/{name}")
    public ResponseEntity<List<EmpEntity>> getData(@PathVariable String name) {
        ResponseEntity<List<EmpEntity>> res;
        try {
            List<EmpEntity> obj1 = empService.getByName(name);
            res = ResponseEntity.status(HttpStatus.OK).body(obj1);
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<EmpEntity>> getData() {
        ResponseEntity<List<EmpEntity>> res;
        try {
            List<EmpEntity> obj1 = empService.getEmpData();
            res = ResponseEntity.status(HttpStatus.OK).body(obj1);
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/add")
    public Boolean saveEmployee(@RequestBody EmpBean empBean) throws ValidationException {
        ResponseEntity<String> response;
        empService.saveEmployee(empBean);
        return true;
    }
    @DeleteMapping("/delete/{emp_id}")
    public Boolean deleteEmployee(@PathVariable int emp_id) throws ValidationException {
        return empService.deleteEmp(emp_id);
    }
    @PutMapping("/update/{emp_id}")
    public Boolean updateEmployee(@PathVariable Integer emp_id,@RequestBody EmpBean empBean) throws ValidationException {
        return empService.updateEmp(emp_id,empBean);
    }
    @GetMapping("/id/{emp_id}")
    public ResponseEntity<Optional<EmpEntity>> getById(@PathVariable int emp_id){
        ResponseEntity<Optional<EmpEntity>> res;
        Optional<EmpEntity> empEntity = empService.getById(emp_id);
        if (empEntity.isPresent()){
            res = ResponseEntity.status(HttpStatus.OK).body(empEntity);
        return  res;
        }
        else {
            res = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(empEntity);
            return res;
        }
    }
    }
