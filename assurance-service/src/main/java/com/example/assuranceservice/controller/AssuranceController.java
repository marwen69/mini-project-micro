package com.example.assuranceservice.controller;

import com.example.assuranceservice.entites.Assurance;
import com.example.assuranceservice.services.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AssuranceController {
    @Autowired
    private AssuranceService assuranceService;

    @PostMapping("/ajouter")
    public ResponseEntity<?> ajouterAssurance(@RequestBody Assurance assurance, @RequestParam int cinBf, @RequestParam Long idContrat) {
        try {
            Assurance addedAssurance = assuranceService.ajouterAssurance(assurance, cinBf, idContrat);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedAssurance);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}


