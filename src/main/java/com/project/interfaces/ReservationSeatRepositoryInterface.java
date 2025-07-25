package com.project.interfaces;

import com.project.domain.entity.ReservationSeat;

public interface ReservationSeatRepositoryInterface {
    ReservationSeat save(ReservationSeat reservationSeat);
    boolean existsHold(Long seatId);
}
