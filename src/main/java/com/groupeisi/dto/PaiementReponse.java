package com.groupeisi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Getter
@Setter
public class PaiementReponse {
    private Long idPaiement;
    private Long idDeclaration;
    private String raisonSociale;
    @NotNull
    private Calendar datePaiement;
    @NotNull
    private Double montantPaiement;
}
