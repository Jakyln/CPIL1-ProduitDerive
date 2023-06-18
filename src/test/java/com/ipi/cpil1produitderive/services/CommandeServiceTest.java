package com.ipi.cpil1produitderive.services;


import com.ipi.cpil1produitderive.dao.CommandeDAO;
import com.ipi.cpil1produitderive.models.Commande;
import com.ipi.cpil1produitderive.models.CommandeProduit;
import com.ipi.cpil1produitderive.models.Produit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class CommandeServiceTest {
    @Autowired
    CommandeService commandeService;

    @Autowired
    CommandeDAO commandeDAO;

   public void testGetSumPrixAchatOfCommandeOnline(){
        //On récupérer le resultat de la fonc sql.
        //Pour vérifier, on va récup toutes les commandes. Puis on fera somme de tout ca
        //Given
        //When
        //Then

        double valueToAssert = commandeService.getSumPrixAchatOfCommandeOnline();
        //On insère mock des 2 commandes en ligne. On connaitra donc la valeur
        /*List<Commande> commandes = commandeDAO.findAll();
        double realValue = 0d;
        for (Commande commande : commandes) {
            if(commande.getPurchasedOnline()){
                List<CommandeProduit> commandeProduits = commande.getCommandeProduits()
                for (CommandeProduit commandeProduit : commandeProduits) {
                    List<Produit> =
                }

            }
        }*/

       //Test avec Mock

       //Instancié les objets
       Produit produit1 = new Produit("prod1","1234",120d,135d, LocalDate.now(),50);
       Produit produit2 = new Produit("prod2","1234",120d,135d, LocalDate.now(),50);
       Produit produit3 = new Produit("prod3","1234",120d,135d, LocalDate.now(),50);
       Produit produit4 = new Produit("prod4","1234",120d,135d, LocalDate.now(),50);
       Produit produit5 = new Produit("prod5","1234",120d,135d, LocalDate.now(),50);
       Produit produit6 = new Produit("prod6","1234",120d,135d, LocalDate.now(),50);

       Commande commande1 = new Commande(LocalDate.now(), LocalDateTime.now(), Boolean.TRUE, Boolean.TRUE);
       Commande commande2 = new Commande(LocalDate.now(), LocalDateTime.now(), Boolean.TRUE, Boolean.TRUE);
       Commande commande3 = new Commande(LocalDate.now(), LocalDateTime.now(), Boolean.FALSE, Boolean.TRUE);

       CommandeProduit commandeProduit1a = new CommandeProduit(2, commande1, produit1);
       CommandeProduit commandeProduit1b = new CommandeProduit(4, commande1, produit2);
       CommandeProduit commandeProduit1c = new CommandeProduit(2, commande1, produit3);


       CommandeProduit commandeProduit2a = new CommandeProduit(2, commande2, produit1);
       CommandeProduit commandeProduit2b = new CommandeProduit(8, commande2, produit4);
       CommandeProduit commandeProduit2c = new CommandeProduit(9, commande2, produit5);
       CommandeProduit commandeProduit2d = new CommandeProduit(47, commande2, produit6);


       CommandeProduit commandeProduit3a = new CommandeProduit(2, commande3, produit1);
       CommandeProduit commandeProduit3b = new CommandeProduit(4, commande3, produit4);
       CommandeProduit commandeProduit3c = new CommandeProduit(1, commande3, produit5);

       //Mocker les objets
       
       produitd
   }
}
