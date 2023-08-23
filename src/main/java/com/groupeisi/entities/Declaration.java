package com.groupeisi.entities;

import com.groupeisi.dto.DeclarationReponse;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "declarations")
public class Declaration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Calendar dateDeclaration;
    private Double montantDeclaration;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Declarant declarant;
    public DeclarationReponse toReponse(){
        DeclarationReponse declarationReponse = new DeclarationReponse();
        declarationReponse.setIdDeclaration(id);
        declarationReponse.setDateDeclaration(dateDeclaration);
        declarationReponse.setMontantDeclaration(montantDeclaration);
        declarationReponse.setIdDeclarant(declarant.getId());
        declarationReponse.setRaisonSociale(declarant.getRaisonSociale());
        return declarationReponse;
    }
}