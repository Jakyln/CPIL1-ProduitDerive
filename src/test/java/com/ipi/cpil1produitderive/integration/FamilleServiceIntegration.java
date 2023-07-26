package com.ipi.cpil1produitderive.integration;

import com.ipi.cpil1produitderive.dao.CommandeDAO;
import com.ipi.cpil1produitderive.dao.CommandeProduitDAO;
import com.ipi.cpil1produitderive.dao.FamilleDAO;
import com.ipi.cpil1produitderive.dao.ProduitDAO;
import com.ipi.cpil1produitderive.models.Commande;
import com.ipi.cpil1produitderive.models.CommandeProduit;
import com.ipi.cpil1produitderive.models.Famille;
import com.ipi.cpil1produitderive.models.Produit;
import com.ipi.cpil1produitderive.pojo.VentesFamille;
import com.ipi.cpil1produitderive.services.FamilleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class FamilleServiceIntegration {

    @Autowired
    FamilleDAO familleDAO;

    @Autowired
    ProduitDAO produitDAO;

    @Autowired
    CommandeDAO commandeDAO;

    @Autowired
    CommandeProduitDAO commandeProduitDAO;

    @Autowired
    FamilleService familleService;

    @BeforeEach
    public void delete(){
        familleDAO.deleteAll();
        commandeProduitDAO.deleteAll();
        produitDAO.deleteAll();
        commandeDAO.deleteAll();
    }

    @Test
    public void testGetVenteFamille() throws Exception {
        //given
        Famille famille = new Famille("figurine", "FIG");
        Famille getFamille = familleDAO.save(famille);

        Produit produit1 = new Produit("P1", "P1", 2.5, 8.0, LocalDate.now(), 40);
        Produit produit2 = new Produit("P2", "P2", 3.5, 10.0, LocalDate.now(), 30);
        produit1.setFamille(famille);
        produit2.setFamille(famille);
        produitDAO.save(produit1);
        produitDAO.save(produit2);

        Commande commandeOnlineValide1 = new Commande(LocalDate.now(), LocalDateTime.now(),true,true);
        Commande commandeNotOnlineValide = new Commande(LocalDate.now(), LocalDateTime.now(),false,true);
        Commande commandeOnlineNotValide = new Commande(LocalDate.now(), LocalDateTime.now(),true,false);
        commandeDAO.save(commandeOnlineValide1);
        commandeDAO.save(commandeNotOnlineValide);
        commandeDAO.save(commandeOnlineNotValide);

        //commandeOnlineValide1
        CommandeProduit commandeProduitC1P1 = new CommandeProduit(2, commandeOnlineValide1, produit1);
        CommandeProduit commandeProduitC1P2 = new CommandeProduit(3, commandeOnlineValide1, produit2);
        //commandeNotOnlineValide
        CommandeProduit commandeProduitC2P1 = new CommandeProduit(1, commandeNotOnlineValide, produit1);
        //commandeOnlineNotValide
        CommandeProduit commandeProduitC3P2 = new CommandeProduit(1, commandeOnlineNotValide, produit2);

        commandeProduitDAO.save(commandeProduitC1P1);
        commandeProduitDAO.save(commandeProduitC1P2);
        commandeProduitDAO.save(commandeProduitC2P1);
        commandeProduitDAO.save(commandeProduitC3P2);

        //when
        System.out.println("famille d'id -> " + getFamille.getId());
        Long idFamille = getFamille.getId();
        VentesFamille ventesFamille = familleService.getVentesFamille(idFamille);
        System.out.println("avant assert");

        //then
        Assertions.assertThat(ventesFamille.famille.getId()).isEqualTo(getFamille.getId());
        Assertions.assertThat(ventesFamille.prixTotal).isEqualTo(54.0);
        Assertions.assertThat(ventesFamille.quantiteVendu).isEqualTo(6);
    }


}
