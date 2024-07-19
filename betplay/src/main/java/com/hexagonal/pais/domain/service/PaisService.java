package com.hexagonal.pais.domain.service;

import java.util.List;

import com.hexagonal.pais.domain.entity.Pais;



public interface PaisService {
    void createPais(Pais Pais);
    void updatePais( String id);
    void deletePais(String id);
    Pais findPaisById(String id);
    List<Pais> findAllPais();
}
