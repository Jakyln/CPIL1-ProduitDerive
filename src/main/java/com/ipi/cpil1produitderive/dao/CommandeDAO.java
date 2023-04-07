package com.ipi.cpil1produitderive.dao;

import com.ipi.cpil1produitderive.models.Adresse;
import com.ipi.cpil1produitderive.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDAO extends JpaRepository<Commande, Long> {
    Double findSumOfCommandeOnline();

    @Query("select SUM(commandeproduit.quantite * produit.prixVente) FROM commandeproduit INNER JOIN produit ON commandeproduit.idProduit = produit.id INNER JOIN commande ON commandeproduit.idCommande = commande.id WHERE commande.isPurchasedOnline = 1 AND produit.nom LIKE 'Figurine Lol' GROUP BY produit.nom\n")
    Double findSumOfCommandeOffline();
}
