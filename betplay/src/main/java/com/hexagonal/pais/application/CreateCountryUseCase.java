package com.hexagonal.pais.application;

import com.hexagonal.pais.domain.entity.Pais;
import com.hexagonal.pais.domain.service.PaisService;


public class CreateCountryUseCase {
 private final PaisService PaisService;

    public CreateCountryUseCase(PaisService PaisService) {
        this.PaisService = PaisService;
    }

    public void execute(Pais pais){
        PaisService.createPais(pais);
    }
}
