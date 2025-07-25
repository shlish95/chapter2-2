package com.project.infrastructure.persistence.reservationSeat;

import com.project.domain.entity.ReservationSeat;
import com.project.interfaces.ReservationSeatRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaReservationSeatRepository implements ReservationSeatRepositoryInterface {

    private final SpringDataReservationSeatRepository repo;

    @Override
    public ReservationSeat save(ReservationSeat reservationSeat) {
        return repo.save(reservationSeat);
    }

    @Override
    public boolean existsHold(Long seatId) {
        return repo.existsHold(seatId);
    }
}
