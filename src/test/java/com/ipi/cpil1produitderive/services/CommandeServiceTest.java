package com.ipi.cpil1produitderive.services;


import com.ipi.cpil1produitderive.dao.CommandeDAO;
import com.ipi.cpil1produitderive.dao.CommandeProduitDAO;
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
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CommandeServiceTest {
    @InjectMocks
    CommandeService commandeService;

    @Mock
    CommandeProduitDAO commandeProduitDAO;

    @Mock
    CommandeDAO commandeDAO;

    public void testGetSumPrixAchatOfCommandeOnline(){
        Produit produit1 = new Produit("P1", "P1", 2.5, 8.0, LocalDate.now(), 40);
        Produit produit2 = new Produit("P2", "P2", 3.5, 10.0, LocalDate.now(), 30);
        Produit produit3 = new Produit("P3", "P3", 5.0, 15.0, LocalDate.now(), 10);
        Produit produit4 = new Produit("P4", "P4", 6.0, 18.0, LocalDate.now(), 10);

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
        commandeOnlineValide1.setCommandeProduits(commandeProduitsListP1);

        List<CommandeProduit> commandeProduitsListP2 = new ArrayList<>();
        commandeProduitsListP2.add(commandeProduitC2P2);
        commandeProduitsListP2.add(commandeProduitC3P2);
        commandeNotOnlineValide.setCommandeProduits(commandeProduitsListP2);
        commandeOnlineNotValide.setCommandeProduits(commandeProduitsListP2);

        List<CommandeProduit> commandeProduitsListP3 = new ArrayList<>();
        commandeProduitsListP3.add(commandeProduitC4P3);
        commandeNotOnlineNotValide.setCommandeProduits(commandeProduitsListP3);

        List<CommandeProduit> commandeProduitsListP4 = new ArrayList<>();
        commandeProduitsListP4.add(commandeProduitC1P4);
        commandeProduitsListP4.add(commandeProduitC2P4);
        commandeProduitsListP4.add(commandeProduitC5P4);
        commandeOnlineValide1.setCommandeProduits(commandeProduitsListP4);
        commandeNotOnlineValide.setCommandeProduits(commandeProduitsListP4);
        commandeOnlineValide2.setCommandeProduits(commandeProduitsListP4);

        List<Commande> commandes = new ArrayList<>();
        commandes.add(commandeOnlineValide1);
        commandes.add(commandeNotOnlineValide);
        commandes.add(commandeOnlineNotValide);
        commandes.add(commandeNotOnlineNotValide);
        commandes.add(commandeOnlineValide2);

        double sumPrixAchatCommandeOnline = 0d;
        for (Commande commande : commandes) {
            if(commande.getPurchasedOnline()){
                List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                for (CommandeProduit commandeProduit : commandeProduits) {
                    sumPrixAchatCommandeOnline += commandeProduit.getProduit().getPrixAchat() * commandeProduit.getQuantite();
                }
            }
        }

        Mockito.when(commandeDAO.findAll()).thenReturn(commandes);
        double result = commandeService.getSumPrixAchatOfCommandeOnline();
        Assertions.assertThat(result).isEqualTo(sumPrixAchatCommandeOnline);
    }
    
    public void testGetSumPrixAchatOfCommandeNotOnline(){
        Produit produit1 = new Produit("P1", "P1", 2.5, 8.0, LocalDate.now(), 40);
        Produit produit2 = new Produit("P2", "P2", 3.5, 10.0, LocalDate.now(), 30);
        Produit produit3 = new Produit("P3", "P3", 5.0, 15.0, LocalDate.now(), 10);
        Produit produit4 = new Produit("P4", "P4", 6.0, 18.0, LocalDate.now(), 10);

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
        commandeOnlineValide1.setCommandeProduits(commandeProduitsListP1);

        List<CommandeProduit> commandeProduitsListP2 = new ArrayList<>();
        commandeProduitsListP2.add(commandeProduitC2P2);
        commandeProduitsListP2.add(commandeProduitC3P2);
        commandeNotOnlineValide.setCommandeProduits(commandeProduitsListP2);
        commandeOnlineNotValide.setCommandeProduits(commandeProduitsListP2);

        List<CommandeProduit> commandeProduitsListP3 = new ArrayList<>();
        commandeProduitsListP3.add(commandeProduitC4P3);
        commandeNotOnlineNotValide.setCommandeProduits(commandeProduitsListP3);

        List<CommandeProduit> commandeProduitsListP4 = new ArrayList<>();
        commandeProduitsListP4.add(commandeProduitC1P4);
        commandeProduitsListP4.add(commandeProduitC2P4);
        commandeProduitsListP4.add(commandeProduitC5P4);
        commandeOnlineValide1.setCommandeProduits(commandeProduitsListP4);
        commandeNotOnlineValide.setCommandeProduits(commandeProduitsListP4);
        commandeOnlineValide2.setCommandeProduits(commandeProduitsListP4);

        List<Commande> commandes = new ArrayList<>();
        commandes.add(commandeOnlineValide1);
        commandes.add(commandeNotOnlineValide);
        commandes.add(commandeOnlineNotValide);
        commandes.add(commandeNotOnlineNotValide);
        commandes.add(commandeOnlineValide2);

        double sumPrixAchatCommandeNotOnline = 0d;
        for (Commande commande : commandes) {
            if(!commande.getPurchasedOnline()){
                List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                for (CommandeProduit commandeProduit : commandeProduits) {
                    sumPrixAchatCommandeNotOnline += commandeProduit.getProduit().getPrixAchat() * commandeProduit.getQuantite();
                }
            }
        }

        Mockito.when(commandeDAO.findAll()).thenReturn(commandes);
        double result = commandeService.getSumPrixAchatOfCommandeNotOnline();
        Assertions.assertThat(result).isEqualTo(sumPrixAchatCommandeNotOnline);
    }
    public void testGetSumPrixVenteOfCommandeOnline(){
        Produit produit1 = new Produit("P1", "P1", 2.5, 8.0, LocalDate.now(), 40);
        Produit produit2 = new Produit("P2", "P2", 3.5, 10.0, LocalDate.now(), 30);
        Produit produit3 = new Produit("P3", "P3", 5.0, 15.0, LocalDate.now(), 10);
        Produit produit4 = new Produit("P4", "P4", 6.0, 18.0, LocalDate.now(), 10);

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
        commandeOnlineValide1.setCommandeProduits(commandeProduitsListP1);

        List<CommandeProduit> commandeProduitsListP2 = new ArrayList<>();
        commandeProduitsListP2.add(commandeProduitC2P2);
        commandeProduitsListP2.add(commandeProduitC3P2);
        commandeNotOnlineValide.setCommandeProduits(commandeProduitsListP2);
        commandeOnlineNotValide.setCommandeProduits(commandeProduitsListP2);

        List<CommandeProduit> commandeProduitsListP3 = new ArrayList<>();
        commandeProduitsListP3.add(commandeProduitC4P3);
        commandeNotOnlineNotValide.setCommandeProduits(commandeProduitsListP3);

        List<CommandeProduit> commandeProduitsListP4 = new ArrayList<>();
        commandeProduitsListP4.add(commandeProduitC1P4);
        commandeProduitsListP4.add(commandeProduitC2P4);
        commandeProduitsListP4.add(commandeProduitC5P4);
        commandeOnlineValide1.setCommandeProduits(commandeProduitsListP4);
        commandeNotOnlineValide.setCommandeProduits(commandeProduitsListP4);
        commandeOnlineValide2.setCommandeProduits(commandeProduitsListP4);

        List<Commande> commandes = new ArrayList<>();
        commandes.add(commandeOnlineValide1);
        commandes.add(commandeNotOnlineValide);
        commandes.add(commandeOnlineNotValide);
        commandes.add(commandeNotOnlineNotValide);
        commandes.add(commandeOnlineValide2);

        double sumPrixVenteCommandeOnline = 0d;
        for (Commande commande : commandes) {
            if(commande.getPurchasedOnline()){
                List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                for (CommandeProduit commandeProduit : commandeProduits) {
                    sumPrixVenteCommandeOnline += commandeProduit.getProduit().getPrixVente() * commandeProduit.getQuantite();
                }
            }
        }

        Mockito.when(commandeDAO.findAll()).thenReturn(commandes);
        double result = commandeService.getSumPrixVenteOfCommandeOnline();
        Assertions.assertThat(result).isEqualTo(sumPrixVenteCommandeOnline);
    }

    public void testGetSumPrixVenteOfCommandeNotOnline(){
        Produit produit1 = new Produit("P1", "P1", 2.5, 8.0, LocalDate.now(), 40);
        Produit produit2 = new Produit("P2", "P2", 3.5, 10.0, LocalDate.now(), 30);
        Produit produit3 = new Produit("P3", "P3", 5.0, 15.0, LocalDate.now(), 10);
        Produit produit4 = new Produit("P4", "P4", 6.0, 18.0, LocalDate.now(), 10);

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
        commandeOnlineValide1.setCommandeProduits(commandeProduitsListP1);

        List<CommandeProduit> commandeProduitsListP2 = new ArrayList<>();
        commandeProduitsListP2.add(commandeProduitC2P2);
        commandeProduitsListP2.add(commandeProduitC3P2);
        commandeNotOnlineValide.setCommandeProduits(commandeProduitsListP2);
        commandeOnlineNotValide.setCommandeProduits(commandeProduitsListP2);

        List<CommandeProduit> commandeProduitsListP3 = new ArrayList<>();
        commandeProduitsListP3.add(commandeProduitC4P3);
        commandeNotOnlineNotValide.setCommandeProduits(commandeProduitsListP3);

        List<CommandeProduit> commandeProduitsListP4 = new ArrayList<>();
        commandeProduitsListP4.add(commandeProduitC1P4);
        commandeProduitsListP4.add(commandeProduitC2P4);
        commandeProduitsListP4.add(commandeProduitC5P4);
        commandeOnlineValide1.setCommandeProduits(commandeProduitsListP4);
        commandeNotOnlineValide.setCommandeProduits(commandeProduitsListP4);
        commandeOnlineValide2.setCommandeProduits(commandeProduitsListP4);

        List<Commande> commandes = new ArrayList<>();
        commandes.add(commandeOnlineValide1);
        commandes.add(commandeNotOnlineValide);
        commandes.add(commandeOnlineNotValide);
        commandes.add(commandeNotOnlineNotValide);
        commandes.add(commandeOnlineValide2);

        double sumPrixVenteCommandeNotOnline = 0d;
        for (Commande commande : commandes) {
            if(!commande.getPurchasedOnline()){
                List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                for (CommandeProduit commandeProduit : commandeProduits) {
                    sumPrixVenteCommandeNotOnline += commandeProduit.getProduit().getPrixVente() * commandeProduit.getQuantite();
                }
            }
        }

        Mockito.when(commandeDAO.findAll()).thenReturn(commandes);
        double result = commandeService.getSumPrixVenteOfCommandeNotOnline();
        Assertions.assertThat(result).isEqualTo(sumPrixVenteCommandeNotOnline);
    }
}
