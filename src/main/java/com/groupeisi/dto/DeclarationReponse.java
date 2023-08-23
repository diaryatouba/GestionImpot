package com.groupeisi.dto;

import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Setter
public class DeclarationReponse {
    private Long idDeclaration;
    private Long idDeclarant;
    private  String raisonSociale;
    @NotNull
    private Calendar dateDeclaration;
    @NotNull
    private Double montantDeclaration;

}
