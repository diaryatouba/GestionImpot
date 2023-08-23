package com.groupeisi.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import com.groupeisi.entities.Paiement;
import java.util.Date;

@Repository
public interface IPaiementDao extends JpaRepository<Paiement, Long> {
    List<Paiement> findByDatePaiementBetween(Date startDate, Date endDate); // Recherche les paiements effectués entre deux dates

    Collection<Object> findAllByDeclaration_Id(Long idDeclaration);
    // Vous pouvez ajouter d'autres méthodes spécifiques ici
}


