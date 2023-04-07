package com.ipi.cpil1produitderive.services;

import com.ipi.cpil1produitderive.dao.AdresseDAO;
import com.ipi.cpil1produitderive.dao.ProduitDAO;
import com.ipi.cpil1produitderive.models.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class ProduitService {
    @Autowired
    private ProduitDAO produitDAO;

    public List<Map<String,Object>> getAllProduitStats(Produit produit) {
        List<Map<String,Object>> allProduitStats = new ArrayList<>();
        return allProduitStats;
    }

}
