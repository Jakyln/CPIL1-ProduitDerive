package com.ipi.cpil1produitderive.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String motDePasse;

    @ManyToOne
    private Adresse adresse;
    @ManyToOne
    private Pays pays;
    @ManyToOne
    private Role role;
    @OneToMany(mappedBy = "utilisateur")
    private List<Commande> commandes;

    public Utilisateur() {
    }

    public Utilisateur(Long id, String email, String motDePasse) {
        this.id = id;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Utilisateur{");
        sb.append("id=").append(id);
        sb.append(", email='").append(email).append('\'');
        sb.append(", motDePasse='").append(motDePasse).append('\'');
        sb.append(", adresse=").append(adresse);
        sb.append(", pays=").append(pays);
        sb.append(", role=").append(role);
        sb.append(", commandes=").append(commandes);
        sb.append('}');
        return sb.toString();
    }
}
