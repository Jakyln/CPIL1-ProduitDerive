package com.ipi.cpil1produitderive.services;

import com.ipi.cpil1produitderive.dao.AdresseDAO;
import com.ipi.cpil1produitderive.dao.ProduitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProduitService {
    @Autowired
    private ProduitDAO produitDAO;
}
