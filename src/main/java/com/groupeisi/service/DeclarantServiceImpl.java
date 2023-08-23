package com.groupeisi.service;

import com.groupeisi.dao.IDeclarantDao;
import com.groupeisi.dto.DeclarantRequete;
import com.groupeisi.entities.Declarant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeclarantServiceImpl implements DeclarantService {
    private final IDeclarantDao declarantDao;

    public DeclarantServiceImpl(IDeclarantDao declarantDao) {
        this.declarantDao = declarantDao;
    }

    @Override
    public Declarant save(DeclarantRequete requete) {
        Declarant declarant = convertir(requete);
        declarantDao.save(declarant);
        return declarant;
    }
    private Declarant convertir (DeclarantRequete requete){
        Declarant declarant = new Declarant();
        declarant.setAdresse(requete.getAdresse());
        declarant.setEmail(requete.getEmail());
        declarant.setTelephone(requete.getTelephone());
        declarant.setRaisonSociale(requete.getRaisonSociale());
        return declarant;
    }
    @Override
    public List<Declarant> lister() {
        return declarantDao.findAll();
    }

}
