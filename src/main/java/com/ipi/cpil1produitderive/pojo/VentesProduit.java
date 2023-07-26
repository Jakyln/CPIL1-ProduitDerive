package com.ipi.cpil1produitderive.pojo;

import com.ipi.cpil1produitderive.models.Produit;

public class VentesProduit {
    public Produit produit;
    public Integer quantiteVendu;
    public Double prixTotal;

    public VentesProduit(Produit produit, Integer quantiteVendu, Double prixTotal) {
        this.produit = produit;
        this.quantiteVendu = quantiteVendu;
        this.prixTotal = prixTotal;
    }
}
