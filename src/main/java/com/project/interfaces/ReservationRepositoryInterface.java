package com.project.interfaces;

import com.project.domain.entity.Reservation;

public interface ReservationRepositoryInterface {
    Reservation save(Reservation reservation);
}
