package com.ipi.cpil1produitderive.dao;

import com.ipi.cpil1produitderive.models.Adresse;
import com.ipi.cpil1produitderive.models.ModePaiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModePaiementDAO extends JpaRepository<ModePaiement, Long> {
}
