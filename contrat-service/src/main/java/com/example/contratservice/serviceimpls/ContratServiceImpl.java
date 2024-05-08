package com.example.contratservice.serviceimpls;

import com.example.contratservice.daos.ContratDao;
import com.example.contratservice.entites.Contrat;
import com.example.contratservice.enumes.TypeContrat;
import com.example.contratservice.services.ContratService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratServiceImpl implements ContratService {
    @Resource
    private ContratDao contratDao;

    @Override
    public Contrat ajouterContrat(Contrat contrat) {
        if (contrat == null) {
            return contratDao.save(contrat);
        } else {
            return contratDao.save(contrat);
        }
    }

    @Override
    public Contrat getContratById(Long id) {
        return contratDao.findById(id).orElse(null);
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        return contratDao.save(contrat);
    }


    @Override
    public Contrat getContratByType(TypeContrat typeContrat) {
        return contratDao.findByTypeContrat(typeContrat);
    }

    @Override
    public Contrat getContratBymatricule(String matricule) {
        List<Contrat> contrats = contratDao.findByMatricule(matricule);
        if (!contrats.isEmpty()) {
            // Assuming you want to return the first found contrat if there are multiple
            return contrats.get(0);
        }
        return null; // Or throw an exception if necessary
    }

    @Override
public List<Contrat> getContratall() {
        return contratDao.findAll();
    }

}
