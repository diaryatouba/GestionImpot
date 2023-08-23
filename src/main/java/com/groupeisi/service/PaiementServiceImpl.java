package com.groupeisi.service;

import com.groupeisi.dao.IDeclarantDao;
import com.groupeisi.dao.IDeclarationDao;
import com.groupeisi.dao.IPaiementDao;
import com.groupeisi.dto.PaiementReponse;
import com.groupeisi.dto.PaiementRequete;
import com.groupeisi.entities.Paiement;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class PaiementServiceImpl implements PaiementService {

    private final IPaiementDao iPaiementDao;
    private final IDeclarationDao iDeclarationDao;
    private final IDeclarantDao iDeclarantDao;

    public PaiementServiceImpl(IPaiementDao iPaiementDao, IDeclarationDao iDeclarationDao, IDeclarantDao iDeclarantDao) {
        this.iPaiementDao = iPaiementDao;
        this.iDeclarationDao = iDeclarationDao;
        this.iDeclarantDao = iDeclarantDao;
    }
    private Paiement convertirPaiement(PaiementRequete  requete) {
        Paiement paiement = new Paiement();
        paiement.setDeclaration(iDeclarationDao.findById(requete.getIdDeclaration()).orElseThrow(() -> new IllegalArgumentException("Declaration non trouve")));
        paiement.setDatePaiement(requete.getDatePaiement());
        paiement.setMontantPaiement(requete.getMontantPaiement());
        return paiement;
    }
    @Override
    public PaiementReponse save(PaiementRequete requete) {
        return iPaiementDao.save(convertirPaiement(requete)).toReponse();
    }

    @Override
    public List<PaiementReponse> lister() {
        return iPaiementDao.findAll().stream().map(x-> x.toReponse()).collect(Collectors.toList());
    }

    @Override
    public List<String> listerPaiementsDeclaration(Long idDeclaration) {
        return null;
    }

   /* @Override
    public List<String> listerPaiementsDeclaration(Long idDeclaration) {
        return iPaiementDao.findAllByDeclaration_Id(idDeclaration).stream().map(x-> x.toReponse() ).collect(Collectors.toList());
        }*/

}
