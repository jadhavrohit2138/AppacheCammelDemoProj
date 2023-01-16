package com.demoProj.controller;

import com.demoProj.entity.ValidationEntity;
import com.demoProj.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    @Autowired
    private ValidationService validationService;

    @GetMapping("/")
    public ResponseEntity<List<ValidationEntity>> getData() {
        ResponseEntity<List<ValidationEntity>> res;
        try {
            List<ValidationEntity> obj1 = validationService.getValidations();
            res = ResponseEntity.status(HttpStatus.OK).body(obj1);
            return res;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
