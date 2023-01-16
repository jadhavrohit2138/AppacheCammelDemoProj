package com.demoProj.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="company1")
public class CompEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comp_id")
    private int compId;

    @Column(name = "comp_name")
    private String compName;

    @OneToMany(mappedBy = "company",cascade = {CascadeType.ALL})
    @JsonManagedReference
    List<EmpEntity> empEntity;
}
