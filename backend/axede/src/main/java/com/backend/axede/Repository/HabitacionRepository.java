package com.backend.axede.Repository;

import com.backend.axede.Entity.Habitacion;
import com.backend.axede.Entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    List<Habitacion> findByHotelAndTipo(Hotel hotel, String tipo);
}
