package com.groupeisi.entities;
import com.groupeisi.dto.DeclarationReponse;
import com.groupeisi.dto.PaiementReponse;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "paiements")
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Calendar datePaiement;
    private double montantPaiement;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_declaration")
    private Declaration declaration;

    public PaiementReponse toReponse() {
        PaiementReponse paiementReponse = new PaiementReponse();
        paiementReponse.setIdPaiement(id);
        paiementReponse.setDatePaiement(datePaiement);
        paiementReponse.setMontantPaiement(montantPaiement);
        paiementReponse.setIdDeclaration(declaration.getId());
        paiementReponse.setRaisonSociale(declaration.getDeclarant().getRaisonSociale());
        return paiementReponse;

    }
}
