package com.example.contratservice.entites;

import com.example.contratservice.enumes.TypeContrat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Contrat implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private String matricule;

    @Temporal(TemporalType.DATE)
    private Date dateEffet;

    @Enumerated(EnumType.STRING)
    private TypeContrat typeContrat;


}
