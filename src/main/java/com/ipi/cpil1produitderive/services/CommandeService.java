package com.ipi.cpil1produitderive.services;

import com.ipi.cpil1produitderive.dao.AdresseDAO;
import com.ipi.cpil1produitderive.dao.CommandeDAO;
import com.ipi.cpil1produitderive.dao.CommandeProduitDAO;
import com.ipi.cpil1produitderive.dao.UtilisateurDAO;
import com.ipi.cpil1produitderive.models.Commande;
import com.ipi.cpil1produitderive.models.CommandeProduit;
import com.ipi.cpil1produitderive.models.Produit;
import com.ipi.cpil1produitderive.models.Utilisateur;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandeService {
    @Autowired
    private CommandeDAO commandeDAO;

    @Autowired
    private UtilisateurDAO utilisateurDAO;
    @Autowired
    private CommandeProduitDAO commandeProduitDAO;

    public double getSumPrixAchatOfCommandeOnline(){
        double sumCommandeOnline = 0d;
        List<Commande> commandes = commandeDAO.findAll();
        for (Commande commande : commandes) {
            if(commande.getPurchasedOnline()){
                List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                for (CommandeProduit commandeProduit : commandeProduits) {
                    sumCommandeOnline += commandeProduit.getProduit().getPrixAchat() * commandeProduit.getQuantite();
                }
            }
        }


        return sumCommandeOnline;
    }


    public double getSumPrixVenteOfCommandeOnline(){
        double sumCommandeNotOnline = 0d;

        List<Commande> commandes = commandeDAO.findAll();
        for (Commande commande : commandes) {
            if(commande.getPurchasedOnline()){
                List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                for (CommandeProduit commandeProduit : commandeProduits) {
                    sumCommandeNotOnline += commandeProduit.getProduit().getPrixVente() * commandeProduit.getQuantite();
                }
            }
        }
        return sumCommandeNotOnline;
    }

    public double getSumPrixAchatOfCommandeNotOnline(){
        double sumCommandeOnline = 0d;

        List<Commande> commandes = commandeDAO.findAll();
        for (Commande commande : commandes) {
            if(!commande.getPurchasedOnline()){
                List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                for (CommandeProduit commandeProduit : commandeProduits) {
                    sumCommandeOnline += commandeProduit.getProduit().getPrixAchat() * commandeProduit.getQuantite();
                }
            }
        }
        return sumCommandeOnline;
    }


    public double getSumPrixVenteOfCommandeNotOnline(){
        double sumCommandeNotOnline = 0d;

        List<Commande> commandes = commandeDAO.findAll();
        for (Commande commande : commandes) {
            if(!commande.getPurchasedOnline()){
                List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                for (CommandeProduit commandeProduit : commandeProduits) {
                    sumCommandeNotOnline += commandeProduit.getProduit().getPrixVente() * commandeProduit.getQuantite();
                }
            }
        }
        return sumCommandeNotOnline;
    }
}
