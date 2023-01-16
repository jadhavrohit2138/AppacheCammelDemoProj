package com.demoProj.repository;

import com.demoProj.entity.EmpEntity;
import com.demoProj.entity.ValidationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidationRepo  extends JpaRepository<ValidationEntity,Integer> {
}
