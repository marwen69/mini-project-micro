package com.example.assuranceservice.serviceimpls;

import com.example.assuranceservice.clients.ContratRestClient;
import com.example.assuranceservice.daos.BenefiaireDao;
import com.example.assuranceservice.entites.Assurance;
import com.example.assuranceservice.entites.Benefiaire;
import com.example.assuranceservice.services.BenefiaireService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BenefiaireServiceImpl implements BenefiaireService {

    @Autowired
    private ContratRestClient contratRestClient;

    @Resource
    private BenefiaireDao benefiaireDao;

    @Override
    public Benefiaire ajouterBeneficiaire(Benefiaire bf) {
        return benefiaireDao.save(bf);

    }


    @Override
    public List<Benefiaire> findAll() {
        return benefiaireDao.findAll();
    }


    // Scheduled method
    @Scheduled(fixedRate = 60000)
    public void statistiques() {
        Map<Integer, Integer> assurancesCountPerBeneficiary = new TreeMap<>(Collections.reverseOrder());

        List<Benefiaire> beneficiaries = benefiaireDao.findAllEagerly();

        for (Benefiaire beneficiaire : beneficiaries) {
            int assuranceCount = beneficiaire.getAssurances().size();
            assurancesCountPerBeneficiary.put(assuranceCount, beneficiaire.getCin());
        }

        System.out.println("Statistiques des assurances par bénéficiaire (par ordre décroissant) :");
        for (Map.Entry<Integer, Integer> entry : assurancesCountPerBeneficiary.entrySet()) {
            System.out.println("Bénéficiaire CIN: " + entry.getValue() + ", Nombre d'assurances: " + entry.getKey());
        }
    }





}
