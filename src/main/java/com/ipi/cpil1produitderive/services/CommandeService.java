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

import java.util.List;

@Service

public class CommandeService {
    @Autowired
    private CommandeDAO commandeDAO;

    @Autowired
    private UtilisateurDAO utilisateurDAO;
    @Autowired
    private CommandeProduitDAO commandeProduitDAO;

    public double getSumPrixAchatCommandeOnline(){
        double sumCommandeOnline = 0d;

        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            List<Commande> commandes = utilisateur.getCommandes();
            for (Commande commande : commandes) {
                if(commande.getPurchasedOnline()){
                    List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                    for (CommandeProduit commandeProduit : commandeProduits) {
                        sumCommandeOnline += commandeProduit.getProduit().getPrixAchat() * commandeProduit.getQuantite();
                    }
                }
            }
        }
        return sumCommandeOnline;
    }

    public double getSumPrixAchatCommandeOnlineOfProduit(Produit produit){
        double sumCommandeOnline = 0d;

        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            List<Commande> commandes = utilisateur.getCommandes();
            for (Commande commande : commandes) {
                if(commande.getPurchasedOnline()){
                    List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                    for (CommandeProduit commandeProduit : commandeProduits) {
                        if(commandeProduit.getProduit().equals(produit)){
                            sumCommandeOnline += commandeProduit.getProduit().getPrixAchat() * commandeProduit.getQuantite();
                        }
                    }
                }
            }
        }
        return sumCommandeOnline;
    }


    public double getSumPrixVenteCommandeOnline(){
        double sumCommandeOnline = 0d;

        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            List<Commande> commandes = utilisateur.getCommandes();
            for (Commande commande : commandes) {
                if(commande.getPurchasedOnline()){
                    List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                    for (CommandeProduit commandeProduit : commandeProduits) {
                        sumCommandeOnline += commandeProduit.getProduit().getPrixVente() * commandeProduit.getQuantite();
                    }
                }
            }
        }
        return sumCommandeOnline;
    }

    public double getSumPrixVenteCommandeOnlineOfProduit(Produit produit){
        double sumCommandeOnline = 0d;

        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            List<Commande> commandes = utilisateur.getCommandes();
            for (Commande commande : commandes) {
                if(commande.getPurchasedOnline()){
                    List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                    for (CommandeProduit commandeProduit : commandeProduits) {
                        if(commandeProduit.getProduit().equals(produit)){
                            sumCommandeOnline += commandeProduit.getProduit().getPrixVente() * commandeProduit.getQuantite();
                        }
                    }
                }
            }
        }
        return sumCommandeOnline;
    }



    public double getSumPrixAchatCommandeOffline(){
        double sumCommandeOnline = 0d;

        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            List<Commande> commandes = utilisateur.getCommandes();
            for (Commande commande : commandes) {
                if(!commande.getPurchasedOnline()){
                    List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                    for (CommandeProduit commandeProduit : commandeProduits) {
                        sumCommandeOnline += commandeProduit.getProduit().getPrixAchat() * commandeProduit.getQuantite();
                    }
                }
            }
        }
        return sumCommandeOnline;
    }

    public double getSumPrixAchatCommandeOfflineOfProduit(Produit produit){
        double sumCommandeOnline = 0d;

        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            List<Commande> commandes = utilisateur.getCommandes();
            for (Commande commande : commandes) {
                if(!commande.getPurchasedOnline()){
                    List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                    for (CommandeProduit commandeProduit : commandeProduits) {
                        if(commandeProduit.getProduit().equals(produit)){
                            sumCommandeOnline += commandeProduit.getProduit().getPrixAchat() * commandeProduit.getQuantite();
                        }
                    }
                }
            }
        }
        return sumCommandeOnline;
    }


    public double getSumPrixVenteCommandeOffline(){
        double sumCommandeOnline = 0d;

        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            List<Commande> commandes = utilisateur.getCommandes();
            for (Commande commande : commandes) {
                if(!commande.getPurchasedOnline()){
                    List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                    for (CommandeProduit commandeProduit : commandeProduits) {
                        sumCommandeOnline += commandeProduit.getProduit().getPrixVente() * commandeProduit.getQuantite();
                    }
                }
            }
        }
        return sumCommandeOnline;
    }

    public double getSumPrixVenteCommandeOfflineOfProduit(Produit produit){
        double sumCommandeOnline = 0d;

        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            List<Commande> commandes = utilisateur.getCommandes();
            for (Commande commande : commandes) {
                if(commande.getPurchasedOnline()){
                    List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                    for (CommandeProduit commandeProduit : commandeProduits) {
                        if(!commandeProduit.getProduit().equals(produit)){
                            sumCommandeOnline += commandeProduit.getProduit().getPrixVente() * commandeProduit.getQuantite();
                        }
                    }
                }
            }
        }
        return sumCommandeOnline;
    }
}
