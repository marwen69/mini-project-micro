package com.example.assuranceservice.entites;

import com.example.assuranceservice.enumes.Profession;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Benefiaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBenef;
    private int cin;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Profession profession;
    private Float salaire;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "benefiaire")
    @JsonIgnore
    private List<Assurance> assurances;



}