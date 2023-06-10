package com.ipi.cpil1produitderive.services;

import com.ipi.cpil1produitderive.dao.AdresseDAO;
import com.ipi.cpil1produitderive.dao.FamilleDAO;
import com.ipi.cpil1produitderive.models.Famille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilleService {
    @Autowired
    private FamilleDAO familleDAO;
}
