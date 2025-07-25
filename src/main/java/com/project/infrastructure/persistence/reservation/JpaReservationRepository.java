package com.project.infrastructure.persistence.reservation;

import com.project.domain.entity.Reservation;
import com.project.interfaces.ReservationRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaReservationRepository implements ReservationRepositoryInterface {

    private final SpringDataReservationRepository repo;

    @Override
    public Reservation save(Reservation reservation) {
        return repo.save(reservation);
    }
}
