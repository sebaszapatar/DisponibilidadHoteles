package com.backend.axede.Services;

import com.backend.axede.Entity.Habitacion;
import com.backend.axede.Entity.Hotel;
import com.backend.axede.Repository.HabitacionRepository;
import com.backend.axede.Repository.HotelRepository;
import com.backend.axede.Repository.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HabitacionRepository habitacionRepository;

    public List<Habitacion> getHabitacionesDisponibles(String ciudad, String tipo) {
        List<Hotel> hoteles = hotelRepository.findByCiudad(ciudad);
        List<Habitacion> habitacionesDisponibles = new ArrayList<>();

        // Definir el número máximo de habitaciones por ciudad
        int maxHabitaciones = obtenerMaxHabitaciones(ciudad, tipo);

        for (Hotel hotel : hoteles) {
            List<Habitacion> habitaciones = habitacionRepository.findByHotelAndTipo(hotel, tipo);

            // Agregar las habitaciones hasta el máximo definido
            for (int i = 0; i < Math.min(habitaciones.size(), maxHabitaciones); i++) {
                habitacionesDisponibles.add(habitaciones.get(i));
            }
        }

        return habitacionesDisponibles;
    }

    private int obtenerMaxHabitaciones(String ciudad, String tipo) {
        switch (ciudad) {
            case "Bogota":
                if (tipo.equals("Estándar")) return 20;
                if (tipo.equals("Premium")) return 20;
                if (tipo.equals("VIP")) return 20;
                break;
            case "Cartagena":
                if (tipo.equals("Estándar")) return 10;
                if (tipo.equals("Premium")) return 1;
                break;
            case "Cali":
                if (tipo.equals("Premium")) return 20;
                if (tipo.equals("VIP")) return 2;
                break;
            case "Barranquilla":
                if (tipo.equals("Estándar")) return 30;
                if (tipo.equals("Premium")) return 3;
                break;
            default:
                return 0; // Si no hay coincidencia, no devuelve habitaciones
        }
        return 0;
    }
}
