package com.example.contratservice.daos;

import com.example.contratservice.entites.Contrat;
import com.example.contratservice.enumes.TypeContrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratDao extends JpaRepository<Contrat, Long> {

    Contrat findByTypeContrat(TypeContrat typeContrat);

    List<Contrat> findByMatricule(String matricule);
}
