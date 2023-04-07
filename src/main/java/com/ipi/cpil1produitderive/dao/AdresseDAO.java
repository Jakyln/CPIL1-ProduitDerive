package com.ipi.cpil1produitderive.dao;

import com.ipi.cpil1produitderive.models.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseDAO extends JpaRepository<Adresse, Long> {
}
