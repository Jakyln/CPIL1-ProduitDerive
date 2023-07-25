package com.ipi.cpil1produitderive.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "code")
    private String code;
    @Column(name = "prixAchat")
    private Double prixAchat;
    @Column(name = "prixVente")
    private Double prixVente;
    @Column(name = "dateReaprovisonnementFournisseur")
    private LocalDate dateReaprovisonnementFournisseur;
    @Column(name = "quantiteEnStock")
    private Integer quantiteEnStock;

    @ManyToOne
    @JoinColumn(name = "idFamille")
    private Famille famille;
    @ManyToOne
    @JoinColumn(name = "idFournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "produit")
    private List<CommandeProduit> commandeProduits;

    public Produit() {
    }

    public Produit(String nom, String code, Double prixAchat, Double prixVente, LocalDate dateReaprovisonnementFournisseur, Integer quantiteEnStock) {
        this.nom = nom;
        this.code = code;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.dateReaprovisonnementFournisseur = dateReaprovisonnementFournisseur;
        this.quantiteEnStock = quantiteEnStock;
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

    public Double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(Double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Double getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Double prixVente) {
        this.prixVente = prixVente;
    }

    public LocalDate getDateReaprovisonnementFournisseur() {
        return dateReaprovisonnementFournisseur;
    }

    public void setDateReaprovisonnementFournisseur(LocalDate dateReaprovisonnementFournisseur) {
        this.dateReaprovisonnementFournisseur = dateReaprovisonnementFournisseur;
    }

    public Integer getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(Integer quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<CommandeProduit> getCommandeProduits() {
        return commandeProduits;
    }

    public void setCommandeProduits(List<CommandeProduit> commandeProduits) {
        this.commandeProduits = commandeProduits;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Produit{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", prixAchat=").append(prixAchat);
        sb.append(", prixVente=").append(prixVente);
        sb.append(", dateReaprovisonnementFournisseur=").append(dateReaprovisonnementFournisseur);
        sb.append(", quantiteEnStock=").append(quantiteEnStock);
        sb.append(", famille=").append(famille);
        sb.append(", fournisseur=").append(fournisseur);
        sb.append('}');
        return sb.toString();
    }
}
