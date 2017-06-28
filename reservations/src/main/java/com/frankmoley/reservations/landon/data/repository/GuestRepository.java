package com.frankmoley.reservations.landon.data.repository;

import com.frankmoley.reservations.landon.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by juan.hernandez on 6/22/17.
 */
public interface GuestRepository extends CrudRepository<Guest, Long> {
}
