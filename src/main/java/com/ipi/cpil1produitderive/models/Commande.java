package com.ipi.cpil1produitderive.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "commande")
@Table(name = "commande")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dateLivraison")
    private LocalDate dateLivraison;
    @Column(name = "dateCommande")
    private LocalDateTime dateCommande;
    @Column(name = "isPurchasedOnline")
    private Boolean isPurchasedOnline;
    @Column(name = "isValide")
    private Boolean isValide;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name = "idModePaiement")
    private ModePaiement modePaiement;
    @ManyToOne
    @JoinColumn(name = "idAdresseLivraison")
    private Adresse adresseLivraison;
    @ManyToOne
    @JoinColumn(name = "idAdresseFacturation")
    private Adresse adresseFacturation;

    @OneToMany(mappedBy = "commande")
    private List<CommandeProduit> commandeProduits;

    public Commande() {
    }

    public Commande(LocalDate dateLivraison, LocalDateTime dateCommande, Boolean isPurchasedOnline, Boolean isValide) {
        this.dateLivraison = dateLivraison;
        this.dateCommande = dateCommande;
        this.isPurchasedOnline = isPurchasedOnline;
        this.isValide = isValide;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Boolean getPurchasedOnline() {
        return isPurchasedOnline;
    }

    public void setPurchasedOnline(Boolean purchasedOnline) {
        isPurchasedOnline = purchasedOnline;
    }

    public Boolean getValide() {
        return isValide;
    }

    public void setValide(Boolean valide) {
        isValide = valide;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public ModePaiement getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(ModePaiement modePaiement) {
        this.modePaiement = modePaiement;
    }

    public Adresse getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(Adresse adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public Adresse getAdresseFacturation() {
        return adresseFacturation;
    }

    public void setAdresseFacturation(Adresse adresseFacturation) {
        this.adresseFacturation = adresseFacturation;
    }

    public List<CommandeProduit> getCommandeProduits() {
        return commandeProduits;
    }

    public void setCommandeProduits(List<CommandeProduit> commandeProduits) {
        this.commandeProduits = commandeProduits;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Commande{");
        sb.append("id=").append(id);
        sb.append(", dateLivraison=").append(dateLivraison);
        sb.append(", dateCommande=").append(dateCommande);
        sb.append(", isPurchasedOnline=").append(isPurchasedOnline);
        sb.append(", isValide=").append(isValide);
        sb.append(", utilisateur=").append(utilisateur);
        sb.append(", modePaiement=").append(modePaiement);
        sb.append(", adresseLivraison=").append(adresseLivraison);
        sb.append(", adresseFacturation=").append(adresseFacturation);
        sb.append('}');
        return sb.toString();
    }
}
