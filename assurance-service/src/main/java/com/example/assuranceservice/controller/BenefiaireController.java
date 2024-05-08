package com.example.assuranceservice.controller;

import com.example.assuranceservice.entites.Benefiaire;
import com.example.assuranceservice.services.BenefiaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BenefiaireController {
    @Autowired
    private BenefiaireService benefiaireService;

    @PostMapping("/beneficiaires")
    public Benefiaire ajouterBeneficiaire(@RequestBody Benefiaire beneficiaire) {
        return benefiaireService.ajouterBeneficiaire(beneficiaire);
    }







}
