package com.project.application;

import com.project.domain.dto.SeatInfo;
import com.project.domain.usecase.ReservationLookupUseCase;
import com.project.interfaces.ConcertRepositoryInterface;
import com.project.interfaces.SeatRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationLookupService implements ReservationLookupUseCase {

    private final ConcertRepositoryInterface concertRepo;
    private final SeatRepositoryInterface seatRepo;

    @Override
    public List<LocalDate> getAvailableDates() {
        return concertRepo.findDistinctDates();
    }

    @Override
    public List<SeatInfo> getAvailableSeats(LocalDate date) {
        return seatRepo.findAvailableSeatsByDate(date);
    }
}
