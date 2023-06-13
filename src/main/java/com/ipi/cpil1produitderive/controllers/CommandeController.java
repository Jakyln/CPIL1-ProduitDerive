package com.ipi.cpil1produitderive.controllers;

import com.ipi.cpil1produitderive.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

@Controller
public class CommandeController {
    @Autowired
    CommandeService commandeService;
    public HashMap<String, Double> getStatsCommande(){
        HashMap<String, Double> statsVente = new HashMap<>();
        double sumPrixAchatCommandeOnline = commandeService.getSumPrixAchatOfCommandeOnline();
        //double sumPrixAchatCommandeOnline = commandeService.getSumPrixAchatOfCommandeOnlineOfProduit();
        double sumPrixVenteOfCommandeOnline = commandeService.getSumPrixVenteOfCommandeOnline();
        //double sumPrixAchatCommandeOnline = commandeService.getSumPrixVenteOfCommandeOnlineOfProduit();
        double sumPrixAchatOfCommandeOffline = commandeService.getSumPrixAchatOfCommandeOffline();
        //double sumPrixAchatCommandeOnline = commandeService.getSumPrixAchatOfCommandeOfflineOfProduit();
        double sumPrixVenteOfCommandeOffline = commandeService.getSumPrixVenteOfCommandeOffline();
        //double sumPrixAchatCommandeOnline = commandeService.getSumPrixVenteOfCommandeOfflineOfProduit();

        statsVente.put("sumPrixAchatCommandeOnline",sumPrixAchatCommandeOnline);
        statsVente.put("sumPrixVenteOfCommandeOnline",sumPrixVenteOfCommandeOnline);
        statsVente.put("sumPrixAchatOfCommandeOffline",sumPrixAchatOfCommandeOffline);
        statsVente.put("sumPrixVenteOfCommandeOffline",sumPrixVenteOfCommandeOffline);

        return statsVente;
    }
}
