package com.example.assuranceservice.clients;


import com.example.assuranceservice.entites.Benefiaire;
import com.example.assuranceservice.models.Contrat;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CONTRACT-SERVICE")
public interface ContratRestClient {
    @GetMapping("/contrats/{id}")
    Contrat getContratById(@PathVariable Long id);

    @GetMapping("/contrats/matricule/{matricule}")
    Contrat getContratByMatricule(@PathVariable String matricule);





    default Benefiaire getDefaultBenefiaire(Long id, Exception exception) {
        if (exception instanceof FeignException.NotFound) {
            // Handle 404 Not Found error
            Benefiaire benefiaire = new Benefiaire();
            benefiaire.setNom("Not available");
            benefiaire.setPrenom("Not available");
            return benefiaire;
        } else {
            // Handle other exceptions
            return null; // Or throw a custom exception
        }
    }

}
