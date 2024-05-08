package com.example.assuranceservice.serviceimpls;

import com.example.assuranceservice.clients.ContratRestClient;
import com.example.assuranceservice.daos.AssuranceDao;
import com.example.assuranceservice.daos.BenefiaireDao;
import com.example.assuranceservice.entites.Assurance;
import com.example.assuranceservice.entites.Benefiaire;
import com.example.assuranceservice.models.Contrat;
import com.example.assuranceservice.services.AssuranceService;
import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssuranceServiceImpl  implements AssuranceService {
    @Resource
    private AssuranceDao assuranceDao;

    @Resource
    private BenefiaireDao benefiaireDao;

    @Autowired
    private ContratRestClient contratRestClient;


    // Implement ajouterAssurance method
    @Override
    public Assurance ajouterAssurance(Assurance a, int cinBf, Long idContrat) {
        // Get Contrat by id using ContratRestClient
        Contrat contrat = contratRestClient.getContratById(idContrat);
        // Check if contrat is not null
        if (contrat != null) {
            // Fetch the existing Benefiaire from your database based on cinBf (assuming you have a method for this)
            Benefiaire benefiaire = benefiaireDao.getByCin(cinBf); // Assuming you have a benefiaireService
            // Check if the Benefiaire exists
            if (benefiaire != null) {
                // Set Benefiaire to Assurance
                a.setBenefiaire(benefiaire);
                // Set idContrat to Assurance
                a.setIdContrat(idContrat);
                // Save or process Assurance further
                // For example, save it to your database
                Assurance savedAssurance = assuranceDao.save(a); // Assuming you have a method like save in your assuranceDao

                return savedAssurance; // Return the newly added Assurance
            } else {
                // Handle the case when Benefiaire is not found
                throw new RuntimeException("Benefiaire not found with cin: " + cinBf);
            }
        } else {
            // Handle the case when Contrat is not found
            throw new RuntimeException("Contrat not found with id: " + idContrat);
        }
    }

}


