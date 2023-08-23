package com.groupeisi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Getter
@NoArgsConstructor
@ToString
public class PaiementRequete {
        private Long idDeclaration;
        @NotNull
        private Calendar datePaiement;
        @NotNull
        private double montantPaiement;
    }


