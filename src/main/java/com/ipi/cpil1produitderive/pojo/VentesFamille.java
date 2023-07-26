package com.ipi.cpil1produitderive.pojo;

import com.ipi.cpil1produitderive.models.Famille;

/**
 * Classe représentant les statistiques de ventes d'une famille
 */
public class VentesFamille {
    public Famille famille;
    public Integer quantiteVendu;
    public Double prixTotal;

    public VentesFamille(Famille famille, Integer quantiteVendu, Double prixTotal) {
        this.famille = famille;
        this.quantiteVendu = quantiteVendu;
        this.prixTotal = prixTotal;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
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
