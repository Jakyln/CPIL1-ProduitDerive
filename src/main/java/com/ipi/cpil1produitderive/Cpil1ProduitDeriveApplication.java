package com.ipi.cpil1produitderive;

import com.ipi.cpil1produitderive.controllers.ConsoleController;
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
public class Cpil1ProduitDeriveApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Cpil1ProduitDeriveApplication.class, args);
        ConsoleController consoleController = applicationContext.getBean(ConsoleController.class);
        consoleController.printConsoleApp();
    }
}
