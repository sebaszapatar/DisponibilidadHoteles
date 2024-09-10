package com.backend.axede.Repository;

import com.backend.axede.Entity.Habitacion;
import com.backend.axede.Entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findByHabitacionAndFechaInicioLessThanEqualAndFechaFinGreaterThanEqual(Habitacion habitacion, String fechaFin, String fechaInicio);
}
