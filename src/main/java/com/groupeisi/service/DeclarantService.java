package com.groupeisi.service;

import com.groupeisi.dto.DeclarantRequete;
import com.groupeisi.entities.Declarant;

import java.util.List;

public interface DeclarantService {
    Declarant save(DeclarantRequete requete);
    List <Declarant> lister();

}
