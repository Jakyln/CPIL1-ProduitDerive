package com.ipi.cpil1produitderive.controllers;

import com.ipi.cpil1produitderive.pojo.VentesFamille;
import com.ipi.cpil1produitderive.pojo.VentesProduit;
import com.ipi.cpil1produitderive.services.CommandeService;
import com.ipi.cpil1produitderive.services.FamilleService;
import com.ipi.cpil1produitderive.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;

@Controller
public class ConsoleController {
    //Se place au dessus de l'affichage du menu et des pages. Comme ca on pourra re afficher le menu en la quittant

    @Autowired
    CommandeService commandeService;

    @Autowired
    FamilleService familleService;

    @Autowired
    ProduitService produitService;


    public void printConsoleApp() throws Exception {
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        this.printMenu();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Rentrer dans la page : ");

        //Lit l'entier écrit par l'utilisateur et l'affecte
        int pageToGo = scanner.nextInt();

        int valueToReturnToMenu = 0;

        switch (pageToGo){
            case 1 :
                valueToReturnToMenu = this.printPageCommandes();
                break;

            case 2 :
                valueToReturnToMenu = this.printPageFamille();
                break;

            case 3 :
                valueToReturnToMenu = this.printPageProduit();
                break;
        }
        if(valueToReturnToMenu == 1){
            this.printConsoleApp();
        }
    }



    public void printMenu(){
        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        System.out.println("--------------------------------- ");
        System.out.println("--------------------------------- ");
        System.out.println("STASTISTIQUES DE PRODUITS DERIVE");
        System.out.println("--------------------------------- ");
        System.out.println("--------------------------------- ");
        System.out.println();
        System.out.println();
        System.out.println("------------------ MENU ------------------");
        System.out.println("(Pour naviguer dans le menu, entrer le numéro correspondant entre parenthèses) ");
        System.out.println();
        System.out.println();
        System.out.println("(1) : Statistiques des commandes faites");
        System.out.println("(2) : Statistiques des familles de produits");
        System.out.println("(3) : Statistiques des produits");
        System.out.println("--------------------");
    }

    //On retournera la valeur de retour au menu
    public int printPageFamille() {

        List<VentesFamille> ventesFamilles = familleService.getAllVentesFamille();

        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("\tPAGE (1) STATISTIQUES COMMANDES");
        System.out.println("----------------------------------------------------------------");

        //System.out.printf("| %-20s | %-8s | %8s |%n", "", "Nom", "Code","Nombre de produits","Nombre vendu");

        for (VentesFamille ventesFamille : ventesFamilles) {
            /*System.out.printf("| %-20s | %-8s | %-8s |%n", "SOMME DE PRIX D'ACHAT",
                    ventesFamille.getFamille().getNom(),
                    ventesFamille.getFamille().getCode(),
                    ventesFamille.getFamille().getProduits().size(),
                    ventesFamille.getQuantiteVendu() );*/
            System.out.println("Nom: " + ventesFamille.getFamille().getNom());

            System.out.println("Code: " + ventesFamille.getFamille().getCode());
            System.out.println("Nombre de produits: " + ventesFamille.getFamille().getProduits().size());
            System.out.println("Nombre vendu: " + ventesFamille.getQuantiteVendu());

            System.out.println("----------------------------------------------------------------");
            //TODO check les données comparé a BDD, rendre plus beau affichage
        }
        System.out.println();

        Scanner scannerToExit = new Scanner(System.in);
        System.out.println("(1) Retour au menu ");

        System.out.print("Rentrer dans la page :");

        return scannerToExit.nextInt();
    }
    public int printPageProduit() throws Exception {

        List<VentesProduit> ventesProduits = produitService.getAllVentesProduit();

        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("\tPAGE (1) STATISTIQUES COMMANDES");
        System.out.println("----------------------------------------------------------------");

        //System.out.printf("| %-20s | %-8s | %8s |%n", "", "Nom", "Code","Nombre de produits","Nombre vendu");

        for (VentesProduit ventesProduit : ventesProduits) {
            /*System.out.printf("| %-20s | %-8s | %-8s |%n", "SOMME DE PRIX D'ACHAT",
                    ventesFamille.getFamille().getNom(),
                    ventesFamille.getFamille().getCode(),
                    ventesFamille.getFamille().getProduits().size(),
                    ventesFamille.getQuantiteVendu() );*/
            System.out.println("Nom: " + ventesProduit.getProduit().getNom());
            System.out.println("Code: " + ventesProduit.getProduit().getCode());
            System.out.println("Famille: " + ventesProduit.getProduit().getFamille().getNom());
            System.out.println("Quantite Vendus: " + ventesProduit.getQuantiteVendu());
            System.out.println("Somme total des commandes : " + ventesProduit.getPrixTotal());

            System.out.println("----------------------------------------------------------------");
            //TODO check les données comparé a BDD, rendre plus beau affichage
        }
        System.out.println();

        Scanner scannerToExit = new Scanner(System.in);
        System.out.println("(1) Retour au menu ");

        System.out.print("Rentrer dans la page :");

        return scannerToExit.nextInt();
    }

    public int  printPageCommandes(){

        double sumPrixAchatCommandeOnline = commandeService.getSumPrixAchatOfCommandeOnline();
        double sumPrixVenteOfCommandeOnline = commandeService.getSumPrixVenteOfCommandeOnline();

        double sumPrixAchatOfCommandeNotOnline = commandeService.getSumPrixAchatOfCommandeNotOnline();
        double sumPrixVenteOfCommandeNotOnline = commandeService.getSumPrixVenteOfCommandeNotOnline();


        for (int i = 0; i < 30; i++) {
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("\tPAGE (1) STATISTIQUES COMMANDES");
        System.out.println("----------------------------------------------------------------");

        System.out.printf("| %-20s | %-8s | %8s |%n", "", "SUR PLACE", "EN LIGNE");
        System.out.println("----------------------------------------------------------------");
        System.out.printf("| %-20s | %-8s | %-8s |%n", "SOMME DE PRIX D'ACHAT", sumPrixAchatOfCommandeNotOnline, sumPrixAchatCommandeOnline );
        System.out.printf("| %-20s | %-8s | %-8s |%n", "SOMME DE PRIX DE VENTE", sumPrixVenteOfCommandeNotOnline, sumPrixVenteOfCommandeOnline );
        System.out.println("----------------------------------------------------------------");
        System.out.println();

        Scanner scannerToExit = new Scanner(System.in);
        System.out.println("(1) Retour au menu ");


        System.out.print("Rentrer dans la page :");

        return scannerToExit.nextInt();
    }



}
