package com.ipi.cpil1produitderive;

import com.ipi.cpil1produitderive.controllers.CommandeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.Console;
import java.util.Scanner;


@Configuration
@SpringBootApplication
@EnableJpaRepositories
@EntityScan( basePackages  = { "com.ipi.cpil1produitderive" })
public class Cpil1ProduitDeriveApplication /*implements CommandLineRunner*/ {
    @Autowired
    CommandeController commandeController;
    public static void main(String[] args) {
/*        ApplicationContext applicationContext = SpringApplication.run(Cpil1ProduitDeriveApplication.class, args);
        CommandeController commandeController = applicationContext.getBean(CommandeController.class);
        System.out.println("------------------------ APP BOOT ------------------------");
        System.out.println(" Somme du prix d'achat total des produits vendus en ligne : " + commandeController.getSumPrixAchatCommandeOnline());
        System.out.println("------------------------ APP END ------------------------");*/

        //SpringApplication.run(Cpil1ProduitDeriveApplication.class, args);

        ApplicationContext applicationContext = SpringApplication.run(Cpil1ProduitDeriveApplication.class, args);

        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------------------- ");
        System.out.println("--------------------------------- ");
        System.out.println("STASTISTIQUES DE PRODUITS DERIVE");
        System.out.println("--------------------------------- ");
        System.out.println("--------------------------------- ");
        System.out.println();
        System.out.println();
        System.out.println("------------------ MENU ------------------");
        System.out.println("(Pour naviguer dans le menu, rentrer le numéro correspondant entre parenthèses) ");
        System.out.println();
        System.out.println();
        System.out.println("(1) : Statistiques des commandes");
        System.out.println("(2) : ");
        System.out.println("(3) : ");
        System.out.println("(4) : ");
        System.out.println("--------------------");

        System.out.print("Rentrer dans la page : ");


        switch (scanner.nextInt()){
            case 1 :
                CommandeController commandeController = applicationContext.getBean(CommandeController.class);
                commandeController.getStatsCommande();
        }

        //Lit l'entier écrit par l'utilisateur et l'affecte
        // à  la variable nombre du programme
        // Affiche le nombre saisit par l'utilisateur






        //String progLanguauge = console.readLine("Enter your favourite programming language: ");
        //console.printf(progLanguauge + " is very interesting!");
        //SpringApplication.run(Cpil1ProduitDeriveApplication.class, args);
    }

/*    @Override
    public void run(String... args) throws Exception {
        //ApplicationContext applicationContext = SpringApplication.run(Cpil1ProduitDeriveApplication.class, args);
        //CommandeController commandeController = applicationContext.getBean(CommandeController.class);
        System.out.println("------------------------ APP BOOT ------------------------");
        System.out.println(" Somme du prix d'achat total des produits vendus en ligne : " + commandeController.getStatsCommande());
        System.out.println("------------------------ APP BOOT ------------------------");

    }*/
}
