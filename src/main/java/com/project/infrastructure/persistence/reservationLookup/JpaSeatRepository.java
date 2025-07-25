package com.project.infrastructure.persistence.reservationLookup;

import com.project.domain.dto.SeatInfo;
import com.project.interfaces.SeatRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaSeatRepository implements SeatRepositoryInterface {

    private final SpringDataSeatRepository repo;

    @Override
    public List<SeatInfo> findAvailableSeatsByDate(LocalDate date) {
        return repo.findAvailableSeatsByDate(date);
    }
}
