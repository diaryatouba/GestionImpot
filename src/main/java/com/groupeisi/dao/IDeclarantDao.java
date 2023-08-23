package com.groupeisi.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.groupeisi.entities.Declarant;
import java.util.List;

@Repository
public interface IDeclarantDao extends JpaRepository<Declarant, Long> {

    Declarant findByEmail(String email); // Recherche un déclarant par adresse email
    // Vous pouvez ajouter d'autres méthodes spécifiques ici
}
