package com.ipi.cpil1produitderive.services;

import com.ipi.cpil1produitderive.dao.FamilleDAO;
import com.ipi.cpil1produitderive.models.Commande;
import com.ipi.cpil1produitderive.models.CommandeProduit;
import com.ipi.cpil1produitderive.models.Famille;
import com.ipi.cpil1produitderive.models.Produit;
import com.ipi.cpil1produitderive.pojo.VentesFamille;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FamilleServiceTest {

    @Mock
    FamilleDAO familleDAO;
    @InjectMocks
    FamilleService familleService;

    @Test
    public void testGetVentesFamille() throws Exception {

        Famille famille1 = new Famille("Figurine", "Fig");

        Produit produit1 = new Produit("P1", "P1", 2.5, 8.0, LocalDate.now(), 40);
        Produit produit2 = new Produit("P2", "P2", 3.5, 10.0, LocalDate.now(), 30);
        Produit produit3 = new Produit("P3", "P3", 5.0, 15.0, LocalDate.now(), 10);
        Produit produit4 = new Produit("P4", "P4", 6.0, 18.0, LocalDate.now(), 10);

        produit1.setFamille(famille1);
        produit2.setFamille(famille1);
        produit3.setFamille(famille1);
        produit4.setFamille(famille1);

        List<Produit> produitsFamille1 = new ArrayList<>();
        produitsFamille1.add(produit1);
        produitsFamille1.add(produit2);
        produitsFamille1.add(produit3);
        produitsFamille1.add(produit4);
        famille1.setProduits(produitsFamille1);

        Commande commandeOnlineValide1 = new Commande(LocalDate.now(), LocalDateTime.now(),true,true);
        Commande commandeNotOnlineValide = new Commande(LocalDate.now(), LocalDateTime.now(),false,true);
        Commande commandeOnlineNotValide = new Commande(LocalDate.now(), LocalDateTime.now(),true,false);
        Commande commandeNotOnlineNotValide = new Commande(LocalDate.now(), LocalDateTime.now(),false,false);
        Commande commandeOnlineValide2 = new Commande(LocalDate.now(), LocalDateTime.now(),true,true);

        //commandeOnlineValide1
        CommandeProduit commandeProduitC1P1 = new CommandeProduit(2, commandeOnlineValide1, produit1);
        CommandeProduit commandeProduitC1P4 = new CommandeProduit(1, commandeOnlineValide1, produit4);
        //commandeNotOnlineValide
        CommandeProduit commandeProduitC2P2 = new CommandeProduit(1, commandeNotOnlineValide, produit2);
        CommandeProduit commandeProduitC2P4 = new CommandeProduit(2, commandeNotOnlineValide, produit4);
        //commandeOnlineNotValide
        CommandeProduit commandeProduitC3P2 = new CommandeProduit(1, commandeOnlineNotValide, produit2);
        //commandeNotOnlineNotValide
        CommandeProduit commandeProduitC4P3 = new CommandeProduit(3, commandeNotOnlineNotValide, produit3);
        //commandeOnlineValide2
        CommandeProduit commandeProduitC5P4 = new CommandeProduit(4, commandeOnlineValide2, produit4);

        //attribution des commandesProduits aux produits
        List<CommandeProduit> commandeProduitsListP1 = new ArrayList<>();
        commandeProduitsListP1.add(commandeProduitC1P1);
        produit1.setCommandeProduits(commandeProduitsListP1);

        List<CommandeProduit> commandeProduitsListP2 = new ArrayList<>();
        commandeProduitsListP2.add(commandeProduitC2P2);
        commandeProduitsListP2.add(commandeProduitC3P2);
        produit2.setCommandeProduits(commandeProduitsListP2);

        List<CommandeProduit> commandeProduitsListP3 = new ArrayList<>();
        commandeProduitsListP3.add(commandeProduitC4P3);
        produit3.setCommandeProduits(commandeProduitsListP3);

        List<CommandeProduit> commandeProduitsListP4 = new ArrayList<>();
        commandeProduitsListP4.add(commandeProduitC1P4);
        commandeProduitsListP4.add(commandeProduitC2P4);
        commandeProduitsListP4.add(commandeProduitC5P4);
        produit4.setCommandeProduits(commandeProduitsListP4);

        //given
        Mockito.when(familleDAO.findById(1L)).thenReturn(Optional.of(famille1));
        //when
        VentesFamille ventesFamille =  familleService.getVentesFamille(1L);
        //then
        Assertions.assertThat(ventesFamille.famille.getNom()).isEqualTo("Figurine");
        Assertions.assertThat(ventesFamille.quantiteVendu).isEqualTo(10);
        Assertions.assertThat(ventesFamille.prixTotal).isEqualTo(152.0);

    }

    @Test
    public void testGetVentesFamilleWithWrongFamilleId(){
        //given
        Mockito.when(familleDAO.findById(1L)).thenReturn(Optional.empty());
        //when
        Throwable t = Assertions.catchThrowable(() -> {
            VentesFamille ventesFamille = familleService.getVentesFamille(1L);
        });
        //then
        Assertions.assertThat(t).hasMessage("Famille non trouvée.");
    }

    @Test
    public void testGetVentesFamilleWithoutCommande() throws Exception {

        Famille famille1 = new Famille("Figurine", "Fig");

        Produit produit1 = new Produit("P1", "P1", 2.5, 8.0, LocalDate.now(), 40);
        Produit produit2 = new Produit("P2", "P2", 3.5, 10.0, LocalDate.now(), 30);

        produit1.setFamille(famille1);
        produit2.setFamille(famille1);

        List<Produit> produitsFamille1 = new ArrayList<>();
        produitsFamille1.add(produit1);
        produitsFamille1.add(produit2);
        famille1.setProduits(produitsFamille1);

        //attribution des commandesProduits aux produits (liste vide)
        List<CommandeProduit> commandeProduitsListP1 = new ArrayList<>();
        produit1.setCommandeProduits(commandeProduitsListP1);

        List<CommandeProduit> commandeProduitsListP2 = new ArrayList<>();
        produit2.setCommandeProduits(commandeProduitsListP2);

        //given
        Mockito.when(familleDAO.findById(1L)).thenReturn(Optional.of(famille1));
        //when
        VentesFamille ventesFamille = familleService.getVentesFamille(1L);
        //then
        Assertions.assertThat(ventesFamille.famille.getNom()).isEqualTo("Figurine");
        Assertions.assertThat(ventesFamille.quantiteVendu).isEqualTo(0);
        Assertions.assertThat(ventesFamille.prixTotal).isEqualTo(0.0);
    }

    @Test
    public void testGetVentesFamilleWithoutValideCommande() throws Exception {

        Famille famille1 = new Famille("Figurine", "Fig");

        Produit produit1 = new Produit("P1", "P1", 2.5, 8.0, LocalDate.now(), 40);
        Produit produit2 = new Produit("P2", "P2", 3.5, 10.0, LocalDate.now(), 30);

        produit1.setFamille(famille1);
        produit2.setFamille(famille1);

        List<Produit> produitsFamille1 = new ArrayList<>();
        produitsFamille1.add(produit1);
        produitsFamille1.add(produit2);
        famille1.setProduits(produitsFamille1);

        Commande commandeOnlineNotValide = new Commande(LocalDate.now(), LocalDateTime.now(),true,false);
        CommandeProduit commandeProduit = new CommandeProduit(1, commandeOnlineNotValide, produit2);

        List<CommandeProduit> commandeProduitsListP1 = new ArrayList<>();
        produit1.setCommandeProduits(commandeProduitsListP1);
        List<CommandeProduit> commandeProduitsListP2 = new ArrayList<>();
        commandeProduitsListP2.add(commandeProduit);
        produit2.setCommandeProduits(commandeProduitsListP2);

        //given
        Mockito.when(familleDAO.findById(1L)).thenReturn(Optional.of(famille1));
        //when
        VentesFamille ventesFamille =  familleService.getVentesFamille(1L);
        //then
        Assertions.assertThat(ventesFamille.famille.getNom()).isEqualTo("Figurine");
        Assertions.assertThat(ventesFamille.quantiteVendu).isEqualTo(0);
        Assertions.assertThat(ventesFamille.prixTotal).isEqualTo(0.0);
    }
}
