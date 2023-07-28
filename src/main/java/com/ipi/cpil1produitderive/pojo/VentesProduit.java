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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Integer getQuantiteVendu() {
        return quantiteVendu;
    }

    public void setQuantiteVendu(Integer quantiteVendu) {
        this.quantiteVendu = quantiteVendu;
    }

    public Double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(Double prixTotal) {
        this.prixTotal = prixTotal;
    }
}
