package com.groupeisi.service;

import com.groupeisi.dao.IDeclarantDao;
import com.groupeisi.dao.IDeclarationDao;
import com.groupeisi.dto.DeclarationReponse;
import com.groupeisi.dto.DeclarationRequete;
import com.groupeisi.entities.Declaration;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeclarationServiceImpl implements DeclarationService {
    private final IDeclarationDao iDeclarationDao;
    private final IDeclarantDao iDeclarantDao;

    public DeclarationServiceImpl(IDeclarationDao iDeclarationDao, IDeclarantDao iDeclarantDao) {
        this.iDeclarationDao = iDeclarationDao;
        this.iDeclarantDao = iDeclarantDao;
    }

    private Declaration convertirDeclaration(DeclarationRequete requete ){
        Declaration declaration = new Declaration();
        declaration.setDeclarant(iDeclarantDao.findById(requete.getIdDeclarant()).orElseThrow(()-> new IllegalArgumentException("Declarant non trouve")));
        declaration.setDateDeclaration(requete.getDateDeclaration());
        declaration.setMontantDeclaration(requete.getMontantDeclaration());

        return declaration;
    }
    @Override
    public DeclarationReponse save(DeclarationRequete requete) {
        return iDeclarationDao.save(convertirDeclaration(requete)).toReponse();
    }

    @Override
    public List<DeclarationReponse> lister() {
        return iDeclarationDao.findAll().stream().map(x-> x.toReponse()).collect(Collectors.toList());
    }

    @Override
    public List<DeclarationReponse> listerDeclarationsDeclarant(Long idDeclarant) {
        return iDeclarationDao.findAllByDeclarant_Id(idDeclarant).stream().map(x-> x.toReponse()).collect(Collectors.toList());
    }
}
