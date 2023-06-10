package com.ipi.cpil1produitderive.controllers;

import com.ipi.cpil1produitderive.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CommandeController {
    @Autowired
    CommandeService commandeService;
    public double getSumPrixAchatCommandeOnline(){
        return commandeService.getSumPrixAchatCommandeOnline();
    }
}
