package com.demoProj.repository;

import com.demoProj.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmpRepo extends JpaRepository<EmpEntity,Integer> {
    public List<EmpEntity> findByName(String name);

    public List<EmpEntity> deleteByName(String name);
}
