package com.example.assuranceservice.services;

import com.example.assuranceservice.entites.Benefiaire;

import java.util.List;
import java.util.Set;

public interface BenefiaireService {
    public Benefiaire ajouterBeneficiaire (Benefiaire bf);


    List<Benefiaire> findAll(); // Method to fetch all beneficiaries
}



