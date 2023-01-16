package com.demoProj.repository;

import com.demoProj.entity.CompEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompRepo extends JpaRepository<CompEntity,Integer> {
}
