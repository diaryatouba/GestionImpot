package com.groupeisi.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "declarants")
public class Declarant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String raisonSociale;
    private String adresse;
    private String email;
    private String telephone;

    // Constructeurs, getters et setters



    public Declarant(String raisonSociale, String adresse, String email, String telephone) {
        this.raisonSociale = raisonSociale;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
    }




}

