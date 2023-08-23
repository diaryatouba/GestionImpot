package com.groupeisi.dto;

import com.groupeisi.entities.Declaration;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@Getter
@NoArgsConstructor
@ToString
public class DeclarantRequete {
    @NotNull
    private String raisonSociale;
    @NotNull
    private String adresse;
    @NotNull @Email
    private String email;
    @NotNull
    private String telephone;

}
