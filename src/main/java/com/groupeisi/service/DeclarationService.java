package com.groupeisi.service;

import com.groupeisi.dto.DeclarationReponse;
import com.groupeisi.dto.DeclarationRequete;
import com.groupeisi.entities.Declarant;

import java.util.List;

public interface DeclarationService  {
    DeclarationReponse save(DeclarationRequete requete);
    List<DeclarationReponse> lister();
    List<DeclarationReponse> listerDeclarationsDeclarant(Long idDeclarant);
}


