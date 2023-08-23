package com.groupeisi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Calendar;


@Getter
@NoArgsConstructor
@ToString
public class DeclarationRequete {
    private Long idDeclarant;
    @NotNull
    private Calendar dateDeclaration;
    @NotNull
    private Double montantDeclaration;
}
