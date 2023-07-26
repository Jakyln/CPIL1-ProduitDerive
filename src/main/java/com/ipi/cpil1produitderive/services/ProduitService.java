package com.ipi.cpil1produitderive.services;

import com.ipi.cpil1produitderive.dao.ProduitDAO;
import com.ipi.cpil1produitderive.models.CommandeProduit;
import com.ipi.cpil1produitderive.models.Produit;
import com.ipi.cpil1produitderive.pojo.VentesProduit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProduitService {
    @Autowired
    private ProduitDAO produitDAO;

    public Produit findById(Long id) throws Exception {
        Optional<Produit> optionalProduit = produitDAO.findById(id);
        if (optionalProduit.isPresent()){
            return optionalProduit.get();
        }
        else{
            throw new Exception("Produit non trouvée.");
        }
    }

    public VentesProduit getVentesProduit(Long produitId) throws Exception {
        Integer quantiteVenduProduit = 0;
        Double prixTotalProduit = 0.0;
        Produit produit = findById(produitId);
        List<CommandeProduit> commandeProduits = produit.getCommandeProduits();
        for (CommandeProduit commandeProduit : commandeProduits) {
            if (commandeProduit.getCommande().getValide()) {
                quantiteVenduProduit += commandeProduit.getQuantite();
            }
        }
        prixTotalProduit += produit.getPrixVente() * quantiteVenduProduit;
        // objet de retour
        VentesProduit ventesProduit = new VentesProduit(produit, quantiteVenduProduit, prixTotalProduit);
        return ventesProduit;
    }

    public List<VentesProduit> getAllVentesProduit() throws Exception {
        Integer quantiteVenduProduit = 0;
        Double prixTotalProduit = 0.0;
        List<Produit> produits = produitDAO.findAll();
        List<VentesProduit> ventesProduits = new ArrayList<>();
        for (Produit produit : produits) {
            List<CommandeProduit> commandeProduits = produit.getCommandeProduits();
            for (CommandeProduit commandeProduit : commandeProduits) {
                if (commandeProduit.getCommande().getValide()) {
                    quantiteVenduProduit += commandeProduit.getQuantite();
                }
            }
            prixTotalProduit += produit.getPrixVente() * quantiteVenduProduit;
            // objet de retour
            VentesProduit ventesProduit = new VentesProduit(produit, quantiteVenduProduit, prixTotalProduit);
            ventesProduits.add(ventesProduit);
        }
        return ventesProduits;
    }
}
