package com.ipi.cpil1produitderive.models;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "famille")
@Table(name = "famille")
public class Famille {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "famille", fetch = FetchType.EAGER)
    private List<Produit> produits;

    public Famille() {
    }

    public Famille(String nom, String code) {
        this.nom = nom;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Famille{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
