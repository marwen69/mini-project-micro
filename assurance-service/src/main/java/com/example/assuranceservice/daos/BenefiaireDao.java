package com.example.assuranceservice.daos;

import com.example.assuranceservice.entites.Benefiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface BenefiaireDao extends JpaRepository<Benefiaire, Long> {
    Benefiaire findByCin(int cinBf);

    /*@Query("SELECT DISTINCT b FROM Benefiaire b JOIN b.assurances a WHERE a.contrat.typeContrat = :typeContrat")
    Set<Benefiaire> getBeneficiairesByType(@Param("typeContrat") TypeContrat typeContrat);*/

    Benefiaire getBeneficiaireByCin(int cinBf);

    @Query("SELECT DISTINCT b FROM Benefiaire b JOIN FETCH b.assurances")
    List<Benefiaire> findAllEagerly();

    Benefiaire getByCin(int cinBf);
}
