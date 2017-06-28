package com.frankmoley.reservations.landon.data.repository;

import com.frankmoley.reservations.landon.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by juan.hernandez on 6/22/17.
 */
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findByDate(Date date);
}
