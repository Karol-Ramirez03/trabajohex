package com.hexagonal.pais.adapter.in;

import com.hexagonal.pais.application.CreateCountryUseCase;

public class PaisConsoleAdapter {
    private final CreateCountryUseCase CreateCountryUseCase;

    public PaisConsoleAdapter(CreateCountryUseCase createCountryUseCase) {
        CreateCountryUseCase = createCountryUseCase;
    }
    

}
