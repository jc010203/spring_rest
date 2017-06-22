package com.frankmoley.reservations.landon.data.repository;

import com.frankmoley.reservations.landon.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by juan.hernandez on 6/21/17.
 */

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Room findByNumber(String roomNumber);
}
