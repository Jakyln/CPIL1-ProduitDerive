package com.ipi.cpil1produitderive.models;

import jakarta.persistence.*;

@Entity
public class FraisDePort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Double montant;

    @OneToOne
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
