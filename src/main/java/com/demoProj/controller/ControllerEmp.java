package com.demoProj.controller;

import com.demoProj.entity.EmpEntity;
import com.demoProj.services.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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


    }
