package com.example.contratservice.controller;

import com.example.contratservice.entites.Contrat;
import com.example.contratservice.enumes.TypeContrat;
import com.example.contratservice.services.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Contratcontroller {
    @Autowired
    private ContratService contratService;

    @PostMapping("/contrats")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }


    @GetMapping("/contrats/{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return contratService.getContratById(id);
    }

    @PutMapping("/contrats")
    public Contrat updateContrat(@RequestBody Contrat contrat) {
        return contratService.updateContrat(contrat);
    }



    @GetMapping("/contrats/type/{typeContrat}")
    public Contrat getContratByType(@PathVariable String typeContrat) {
        TypeContrat type = TypeContrat.valueOf(typeContrat.toUpperCase()); // Assuming typeContrat is passed as uppercase enum name
        return contratService.getContratByType(type);
    }

    @GetMapping("/contrats/matricule/{matricule}")
    public Contrat getContratBymatricule(@PathVariable String matricule) {
        return contratService.getContratBymatricule(matricule);
    }

    @GetMapping("/contrats")
    public List<Contrat> getContratall() {
        return contratService.getContratall();
    }

}
