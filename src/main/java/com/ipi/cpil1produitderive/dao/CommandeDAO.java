package com.ipi.cpil1produitderive.dao;

import com.ipi.cpil1produitderive.models.Adresse;
import com.ipi.cpil1produitderive.models.Commande;
import com.ipi.cpil1produitderive.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeDAO extends JpaRepository<Commande, Long> {

    @Query(value = "SELECT c FROM Commande c WHERE c.utilisateur = :utilisateur ")
    List<Commande> findAllByUtilisateur(Utilisateur utilisateur);

    @Query(value = "SELECT c FROM Commande c")
    List<Commande> findAll();



}
