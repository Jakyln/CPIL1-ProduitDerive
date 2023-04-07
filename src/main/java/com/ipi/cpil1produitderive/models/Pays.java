package com.ipi.cpil1produitderive.models;

import jakarta.persistence.*;

@Entity
public class Pays {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    private Integer dureeLivraison;

    @OneToOne
    private FraisDePort fraisDePort;

    public Pays() {
    }

    public Pays(Long id, String nom, Integer dureeLivraison) {
        this.id = id;
        this.nom = nom;
        this.dureeLivraison = dureeLivraison;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getDureeLivraison() {
        return dureeLivraison;
    }

    public void setDureeLivraison(Integer dureeLivraison) {
        this.dureeLivraison = dureeLivraison;
    }

    public FraisDePort getFraisDePort() {
        return fraisDePort;
    }

    public void setFraisDePort(FraisDePort fraisDePort) {
        this.fraisDePort = fraisDePort;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pays{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", dureeLivraison=").append(dureeLivraison);
        sb.append(", fraisDePort=").append(fraisDePort);
        sb.append('}');
        return sb.toString();
    }
}
