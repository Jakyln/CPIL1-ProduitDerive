package com.ipi.cpil1produitderive.models;

import jakarta.persistence.*;

@Entity(name = "fraisDePort")
@Table(name = "fraisDePort", schema = "produit_derive", catalog = "produit_derive")
public class FraisDePort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "montant")
    private Double montant;

    @OneToOne
    @JoinColumn(name = "idPays")
    private Pays pays;

    public FraisDePort() {
    }

    public FraisDePort(Long id, Double montant) {
        this.id = id;
        this.montant = montant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FraisDePort{");
        sb.append("id=").append(id);
        sb.append(", montant=").append(montant);
        sb.append(", pays=").append(pays);
        sb.append('}');
        return sb.toString();
    }
}
