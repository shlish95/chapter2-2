package com.project.interfaces;

import com.project.domain.dto.SeatInfo;

import java.time.LocalDate;
import java.util.List;

public interface SeatRepositoryInterface {
    List<SeatInfo> findAvailableSeatsByDate(LocalDate date);
}
