package com.project.infrastructure.persistence.reservation;

import com.project.domain.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataReservationRepository extends JpaRepository<Reservation, Long> {
}
