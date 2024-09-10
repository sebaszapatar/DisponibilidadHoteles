package com.backend.axede.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TarifaService {

    public double calcularTarifa(String tipoHabitacion, String temporada, int numPersonas){
        double tarifaBase;

        switch (tipoHabitacion){
            case "Estandar":
                tarifaBase = 100;
                break;
            case "Premium":
                tarifaBase = 150;
                break;
            case "VIP":
                tarifaBase = 200;
                break;
            default:
                tarifaBase = 0;
        }

        if ("Alta".equalsIgnoreCase(temporada)){
            tarifaBase *=1.2;
        }
        return tarifaBase * numPersonas;
    }
}
