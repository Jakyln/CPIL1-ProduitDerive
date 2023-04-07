package com.ipi.cpil1produitderive.dao;

import com.ipi.cpil1produitderive.models.Adresse;
import com.ipi.cpil1produitderive.models.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurDAO extends JpaRepository<Fournisseur, Long> {
}
