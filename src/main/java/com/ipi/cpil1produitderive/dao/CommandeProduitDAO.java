package com.ipi.cpil1produitderive.dao;

import com.ipi.cpil1produitderive.models.Adresse;
import com.ipi.cpil1produitderive.models.CommandeProduit;
import com.ipi.cpil1produitderive.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeProduitDAO extends JpaRepository<CommandeProduit, Long> {
    //Chiffre d'affaires
    @Query(value = "SELECT SUM(commandeproduit.quantite * produit.prixAchat) FROM commandeproduit INNER JOIN produit ON commandeproduit.idProduit = produit.id INNER JOIN commande ON commandeproduit.idCommande = commande.id WHERE commande.isPurchasedOnline = 0", nativeQuery = true)
    Double getSumPrixAchatOfCommandeOffline();

    @Query(value = "SELECT SUM(commandeproduit.quantite * produit.prixAchat) FROM commandeproduit INNER JOIN produit ON commandeproduit.idProduit = produit.id INNER JOIN commande ON commandeproduit.idCommande = commande.id WHERE commande.isPurchasedOnline = 1", nativeQuery = true)
    Double getSumPrixAchatOfCommandeOnline();

    @Query(value = "SELECT SUM(commandeproduit.quantite * produit.prixAchat) FROM commandeproduit INNER JOIN produit ON commandeproduit.idProduit = produit.id INNER JOIN commande ON commandeproduit.idCommande = commande.id WHERE commande.isPurchasedOnline = 1 AND commandeproduit.idProduit = ?", nativeQuery = true)
    Double getSumPrixAchatOfCommandeOnlineOfProduit(long idProduit);


    @Query(value = "SELECT SUM(commandeproduit.quantite * produit.prixAchat) FROM commandeproduit INNER JOIN produit ON commandeproduit.idProduit = produit.id INNER JOIN commande ON commandeproduit.idCommande = commande.id WHERE commande.isPurchasedOnline = 0 AND commandeproduit.idProduit = ?", nativeQuery = true)
    Double getSumPrixAchatOfCommandeOfflineOfProduit(long idProduit);

    //Marge Brut dégagé
    @Query(value = "SELECT SUM(commandeproduit.quantite * produit.prixVente) FROM commandeproduit INNER JOIN produit ON commandeproduit.idProduit = produit.id INNER JOIN commande ON commandeproduit.idCommande = commande.id WHERE commande.isPurchasedOnline = 0", nativeQuery = true)
    Double getSumPrixVenteOfCommandeOffline();

    @Query(value = "SELECT SUM(commandeproduit.quantite * produit.prixVente) FROM commandeproduit INNER JOIN produit ON commandeproduit.idProduit = produit.id INNER JOIN commande ON commandeproduit.idCommande = commande.id WHERE commande.isPurchasedOnline = 1", nativeQuery = true)
    Double getSumPrixVenteOfCommandeOnline();

    @Query(value = "SELECT SUM(commandeproduit.quantite * produit.prixVente) FROM commandeproduit INNER JOIN produit ON commandeproduit.idProduit = produit.id INNER JOIN commande ON commandeproduit.idCommande = commande.id WHERE commande.isPurchasedOnline = 1 AND commandeproduit.idProduit = ?", nativeQuery = true)
    Double getSumPrixVenteOfCommandeOnlineOfProduit(long idProduit);


    @Query(value = "SELECT SUM(commandeproduit.quantite * produit.prixVente) FROM commandeproduit INNER JOIN produit ON commandeproduit.idProduit = produit.id INNER JOIN commande ON commandeproduit.idCommande = commande.id WHERE commande.isPurchasedOnline = 0 AND commandeproduit.idProduit = ?", nativeQuery = true)
    Double getSumPrixVenteOfCommandeOfflineOfProduit(long idProduit);
}
