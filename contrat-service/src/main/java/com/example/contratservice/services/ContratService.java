package com.example.contratservice.services;


import com.example.contratservice.entites.Contrat;
import com.example.contratservice.enumes.TypeContrat;

import java.util.List;

public interface ContratService {
    // add a contract
    public Contrat ajouterContrat(Contrat contrat);
    public Contrat getContratById(Long id);
    public Contrat updateContrat(Contrat contrat);
    public Contrat getContratByType(TypeContrat typeContrat);
    public Contrat getContratBymatricule(String matricule);
    public List<Contrat> getContratall();

}
