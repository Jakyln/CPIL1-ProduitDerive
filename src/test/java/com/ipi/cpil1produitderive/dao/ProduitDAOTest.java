package com.ipi.cpil1produitderive.dao;

import com.ipi.cpil1produitderive.models.Produit;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProduitDAOTest {
    @Autowired
    ProduitDAO produitDAO;

    public void testGetAllProduits(){
        //given
        List<Produit> produitList = produitDAO.findAll();
        //When
       // Assertions.assertThat()
        //Then
    }
}
