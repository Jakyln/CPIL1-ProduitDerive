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

@Configuration
@SpringBootApplication
@EnableJpaRepositories
@EntityScan( basePackages  = { "com.ipi.cpil1produitderive" })
public class Cpil1ProduitDeriveApplication implements CommandLineRunner {
    @Autowired
    CommandeController commandeController;
    public static void main(String[] args) {
/*        ApplicationContext applicationContext = SpringApplication.run(Cpil1ProduitDeriveApplication.class, args);
        CommandeController commandeController = applicationContext.getBean(CommandeController.class);
        System.out.println("------------------------ APP BOOT ------------------------");
        System.out.println(" Somme du prix d'achat total des produits vendus en ligne : " + commandeController.getSumPrixAchatCommandeOnline());
        System.out.println("------------------------ APP END ------------------------");*/

        SpringApplication.run(Cpil1ProduitDeriveApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //ApplicationContext applicationContext = SpringApplication.run(Cpil1ProduitDeriveApplication.class, args);
        //CommandeController commandeController = applicationContext.getBean(CommandeController.class);
        System.out.println("------------------------ APP BOOT ------------------------");
        System.out.println(" Somme du prix d'achat total des produits vendus en ligne : " + commandeController.getStatsCommande());
        System.out.println("------------------------ APP BOOT ------------------------");

    }
}
