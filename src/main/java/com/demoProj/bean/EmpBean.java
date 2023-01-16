package com.demoProj.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpBean {

    private Integer empId;
    private String name;
    private int compId;
    private String operation;
}
