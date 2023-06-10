package com.ipi.cpil1produitderive.dao;

import com.ipi.cpil1produitderive.models.Adresse;
import com.ipi.cpil1produitderive.models.CommandeProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeProduitDAO extends JpaRepository<CommandeProduit, Long> {
    @Query(value = "SELECT SUM(commandeproduit.quantite * produit.prixVente) FROM commandeproduit INNER JOIN produit ON commandeproduit.idProduit = produit.id INNER JOIN commande ON commandeproduit.idCommande = commande.id WHERE commande.isPurchasedOnline = 0", nativeQuery = true)
    Double getSumOfCommandeOffline();

    @Query(value = "SELECT SUM(commandeproduit.quantite * produit.prixAchat) FROM commandeproduit INNER JOIN produit ON commandeproduit.idProduit = produit.id INNER JOIN commande ON commandeproduit.idCommande = commande.id WHERE commande.isPurchasedOnline = 1", nativeQuery = true)
    Double getSumOfCommandeOnline();
}
