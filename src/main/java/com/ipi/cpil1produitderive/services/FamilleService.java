package com.ipi.cpil1produitderive.services;

import com.ipi.cpil1produitderive.dao.FamilleDAO;
import com.ipi.cpil1produitderive.models.CommandeProduit;
import com.ipi.cpil1produitderive.models.Famille;
import com.ipi.cpil1produitderive.models.Produit;
import com.ipi.cpil1produitderive.pojo.VentesFamille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FamilleService {
    @Autowired
    private FamilleDAO familleDAO;

    public Famille findById(Long id) throws Exception {
        Optional<Famille> optionalFamille = familleDAO.findById(id);
        if (optionalFamille.isPresent()){
            return optionalFamille.get();
        }
        else{
            throw new Exception("Famille non trouvée.");
        }
    }

    /**
     * Renvoi les résultats de ventes d'une famille
     * @param familleId Id de la famille
     * @return VenteByFamille
     */
    public VentesFamille getVentesFamille(Long familleId) throws Exception{
        Integer quantiteVenduFamille = 0;
        Integer quantiteVenduProduit = 0;
        Double prixTotalFamille = 0.0;
        Famille famille = findById(familleId);
        List<Produit> produits = famille.getProduits();
        for (Produit produit : produits) {
            quantiteVenduProduit = 0;
            List<CommandeProduit> commandeProduits = produit.getCommandeProduits();
            for (CommandeProduit commandeProduit : commandeProduits) {
                if (commandeProduit.getCommande().getValide()) {
                    quantiteVenduFamille += commandeProduit.getQuantite();
                    quantiteVenduProduit += commandeProduit.getQuantite();
                }
            }
            prixTotalFamille += produit.getPrixVente() * quantiteVenduProduit;
        }
        // objet de retour
        VentesFamille ventesFamille = new VentesFamille(famille, quantiteVenduFamille, prixTotalFamille);
        return ventesFamille;
    }

    /**
     * Renvoit les résultats de ventes de toutes les familles
     * @return VenteByFamille
     */
    public List<VentesFamille> getAllVentesFamille() {
        Integer quantiteVenduFamille = 0;
        Integer quantiteVenduProduit = 0;
        Double prixTotalFamille = 0.0;
        List<Famille> familles = familleDAO.findAll();
        List<VentesFamille> ventesFamilles = new ArrayList<>();
        for (Famille famille : familles) {
            List<Produit> produits = famille.getProduits();
            for (Produit produit : produits) {
                quantiteVenduProduit = 0;
                List<CommandeProduit> commandeProduits = produit.getCommandeProduits();
                for (CommandeProduit commandeProduit : commandeProduits) {
                    if (commandeProduit.getCommande().getValide()) {
                        quantiteVenduFamille += commandeProduit.getQuantite();
                        quantiteVenduProduit += commandeProduit.getQuantite();
                    }
                }
                prixTotalFamille += produit.getPrixVente() * quantiteVenduProduit;
            }
            VentesFamille ventesFamille = new VentesFamille(famille, quantiteVenduFamille, prixTotalFamille);
            ventesFamilles.add(ventesFamille);
        }
        // objet de retour
        return ventesFamilles;
    }

}
