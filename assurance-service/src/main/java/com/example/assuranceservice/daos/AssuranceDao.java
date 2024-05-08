package com.example.assuranceservice.daos;

import com.example.assuranceservice.entites.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssuranceDao extends JpaRepository<Assurance, Long> {
}
