package com.groupeisi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.groupeisi.entities.Declaration;
import java.util.List;

@Repository
public interface IDeclarationDao extends JpaRepository<Declaration, Long> {
    List<Declaration> findByMontantDeclarationGreaterThan(double montant); // Recherche les déclarations avec un montant supérieur à une valeur donnée
    // Vous pouvez ajouter d'autres méthodes spécifiques ici
    List<Declaration> findAllByDeclarant_Id(Long id);
}
