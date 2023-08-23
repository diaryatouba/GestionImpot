package com.groupeisi.service;

import com.groupeisi.dto.PaiementReponse;
import com.groupeisi.dto.PaiementRequete;

import java.util.List;

public interface PaiementService {
    PaiementReponse save(PaiementRequete requete);
    List<PaiementReponse> lister();
    List<String> listerPaiementsDeclaration(Long idDeclaration);
}
