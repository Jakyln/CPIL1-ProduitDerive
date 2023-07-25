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
}
