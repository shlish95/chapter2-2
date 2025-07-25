package com.project.interfaces;

import java.time.LocalDate;
import java.util.List;

public interface ConcertRepositoryInterface {
    List<LocalDate> findDistinctDates();
}
