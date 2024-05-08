package com.example.assuranceservice.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Assurance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAssurance;
    private String Designation;
    private Float montant;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinColumn(name = "beneficiaire_id")
    private Benefiaire benefiaire;

    // In Assurance entity
    @Column(name = "id_contrat")
    private Long idContrat;



}
