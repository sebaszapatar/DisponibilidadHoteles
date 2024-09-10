package com.backend.axede.Rest;

import com.backend.axede.Entity.Habitacion;
import com.backend.axede.Services.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/disponibilidad")
    public ResponseEntity<List<Habitacion>> getDisponibilidad(
            @RequestParam String ciudad,
            @RequestParam String tipo) {
        List<Habitacion> disponibles = hotelService.getHabitacionesDisponibles(ciudad, tipo);
        return ResponseEntity.ok(disponibles);
    }

}
