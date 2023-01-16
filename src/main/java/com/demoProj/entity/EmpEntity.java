package com.demoProj.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee1")

public class EmpEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "comp_id")
    private int comp_id;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "comp_id",nullable = false,insertable = false,updatable = false)
//    @JsonBackReference
//    CompEntity compEntity;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(foreignKey = @ForeignKey(name = "comp_id"), name = "comp_id")
//    private CompEntity compEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="comp_id", nullable=false,insertable = false ,updatable = false)
    @JsonBackReference
    CompEntity company;

}
