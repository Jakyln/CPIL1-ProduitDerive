package com.ipi.cpil1produitderive.controllers;

import com.ipi.cpil1produitderive.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ConsoleController {
    //Se place au dessus de l'affichage du menu et des pages. Comme ca on pourra re afficher le menu en la quittant

    @Autowired
    CommandeService commandeService;


    public void printConsoleApp(){
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

            case 2 :

            case 3 :

            case 4 :
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

    //On retournera la velour de retour au menu
    public int printPageCommandes(){

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
