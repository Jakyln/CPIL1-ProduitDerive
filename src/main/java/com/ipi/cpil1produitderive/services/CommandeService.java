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
    /*public double getSumPrixVenteOfCommande(String typeCommande){
        double sumCommande = 0d;

        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            List<Commande> commandes = commandeDAO.findAllByUtilisateur(utilisateur);
            for (Commande commande : commandes) {
                switch (typeCommande) {
                    case "online":
                        if(commande.getPurchasedOnline()){
                            List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                            double sumCommandeOnline = 0d;
                            for (CommandeProduit commandeProduit : commandeProduits) {
                                sumCommandeOnline += commandeProduit.getProduit().getPrixVente() * commandeProduit.getQuantite();
                            }
                            sumCommande = sumCommandeOnline;
                        }
                        break;
                    case "notOnline":
                        if(!commande.getPurchasedOnline()){
                            List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                            double sumCommandeNotOnline = 0d;
                            for (CommandeProduit commandeProduit : commandeProduits) {
                                sumCommandeNotOnline += commandeProduit.getProduit().getPrixVente() * commandeProduit.getQuantite();
                            }
                            sumCommande = sumCommandeNotOnline;
                        }
                        break;
                }
            }
        }
        return sumCommande;
    }*/
    /*public double getSumPrixAchatOfCommandeOnline(){
        double sumCommandeOnline = 0d;

        List<Utilisateur> utilisateurs = utilisateurDAO.findAll();
        for (Utilisateur utilisateur : utilisateurs) {
            List<Commande> commandes = commandeDAO.findAllByUtilisateur(utilisateur);
            System.out.println(utilisateur.getId());
            //List<Commande> commandes = commandeDAO.findAll();
            //List<Commande> commandes = new ArrayList<>();
            System.out.println("commandes :" + utilisateur.getCommandes().size());
            for (Commande commande : commandes) {
                if(commande.getPurchasedOnline()){
                    List<CommandeProduit> commandeProduits = commande.getCommandeProduits();
                    for (CommandeProduit commandeProduit : commandeProduits) {
                        sumCommandeOnline += commandeProduit.getProduit().getPrixAchat() * commandeProduit.getQuantite();
                    }
                }
            }
        }
//        System.out.println(" fonc getSumPrixAchatOfCommandeOnline : res loop ="
//                + sumCommandeOnline + "| res SQL =" + commandeProduitDAO.getSumPrixAchatOfCommandeOnline());
        return sumCommandeOnline;
        //return commandeProduitDAO.getSumPrixAchatOfCommandeOnline();
    }*/

    public double getSumPrixAchatOfCommandeOnlineOfProduit(Produit produit){
        /*double sumCommandeOnline = 0d;

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
        }*/
        return commandeProduitDAO.getSumPrixAchatOfCommandeOnlineOfProduit(produit.getId());
    }


    /*public double getSumPrixVenteOfCommandeOnline(){
        *//*double sumCommandeOnline = 0d;

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
        }*//*
        return commandeProduitDAO.getSumPrixVenteOfCommandeOnline();
    }*/

    public double getSumPrixVenteOfCommandeOnlineOfProduit(Produit produit){
        /*double sumCommandeOnline = 0d;

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
        }*/
        return commandeProduitDAO.getSumPrixVenteOfCommandeOnlineOfProduit(produit.getId());
    }



    /*public double getSumPrixAchatOfCommandeOffline(){
        *//*double sumCommandeOnline = 0d;

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
        }*//*
        return commandeProduitDAO.getSumPrixAchatOfCommandeOffline();
    }*/

    public double getSumPrixAchatOfCommandeOfflineOfProduit(Produit produit){
        /*double sumCommandeOnline = 0d;

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
        }*/
        return commandeProduitDAO.getSumPrixAchatOfCommandeOfflineOfProduit(produit.getId());
    }


    /*public double getSumPrixVenteOfCommandeOffline(){
        *//*double sumCommandeOnline = 0d;

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
        }*//*
        return commandeProduitDAO.getSumPrixVenteOfCommandeOffline();
    }*/

    public double getSumPrixVenteOfCommandeOfflineOfProduit(Produit produit){
        /*double sumCommandeOnline = 0d;

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
        }*/
        return commandeProduitDAO.getSumPrixVenteOfCommandeOfflineOfProduit(produit.getId());
    }
}
