package com.project.infrastructure.persistence.reservationLookup;

import com.project.domain.usecase.ReservationLookupUseCase;
import com.project.interfaces.ConcertRepositoryInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaConcertRepository implements ConcertRepositoryInterface {

    private final SpringDataConcertRepository repo;

    @Override
    public List<LocalDate> findDistinctDates() {
        return repo.findDistinctDates();
    }
}
